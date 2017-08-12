package org.terrytsao.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.terrytsao.model.CatVac;
import org.terrytsao.model.DogVac;
import org.terrytsao.model.Pet;
import org.terrytsao.model.PetVaccinationRecord;
import org.terrytsao.model.User;
import org.terrytsao.model.VacArr;
import org.terrytsao.service.MyService;
import org.terrytsao.tool.DateTool;
import org.terrytsao.tool.EnumTool;

@Controller
@RequestMapping("/user/{pid:^\\d+$}")
public class AddVacController {
	@Autowired
	@Qualifier("myService")
	private MyService myService;

	private User user;

	private Pet pet;

	@RequestMapping("/addVac")
	public String addVacForm(@RequestParam Map<String, String> params,
			Model model) {
		model.addAllAttributes(params);
		if (!model.containsAttribute("vac")) {
			VacArr vacArr = new VacArr();
			model.addAttribute("vac", vacArr);
		}

		// TODO
		model.addAttribute("petType", pet.getSpecies().toString());

		switch (pet.getSpecies()) {
			case CAT :
				model.addAttribute("vacList",
						EnumTool.getEnumValues(CatVac.class));
				break;
			case DOG :
				model.addAttribute("vacList",
						EnumTool.getEnumValues(DogVac.class));
				break;
			default :
				throw new FatalBeanException("Fatal error here!!!");
		}

		return "addVac";
	}

	@RequestMapping(value = "/addVacProcess", method = RequestMethod.POST)
	public String processAddVacForm(
			@ModelAttribute("vac") VacArr vacArr,
			@RequestParam Map<String, String> params, RedirectAttributes ra) {
		String date = params.get("vacDate");
		String weightStr = params.get("weight");
		String vet = params.get("vet");
		String[] vacs = vacArr.getVacs();

		ra.addAllAttributes(params);
		ra.addFlashAttribute("vac", vacArr);

		boolean sthIsFishy = false;
		if (0 == vacs.length) {
			ra.addAttribute("vacsIsEmpty", "true");
			sthIsFishy = true;
		}

		Date d = null;
		if (0 == date.length()) {
			ra.addAttribute("dateIsEmpty", "true");
			sthIsFishy = true;
		} else {
			d = DateTool.isDateFormatted(date);
			if (d == null) {
				ra.addAttribute("dateWrongFormat", "true");
				sthIsFishy = true;
			}
		}

		double weight = 0;
		if (weightStr.length() > 0) {
			try {
				weight = Double.parseDouble(weightStr);
				if (weight <= 1e-5) {
					sthIsFishy = true;
					ra.addAttribute("weightWrongFormat", weightStr);
				}
			} catch (NumberFormatException ex) {
				ra.addAttribute("weightWrongFormat", weightStr);
				sthIsFishy = true;
			}
		}

		if (sthIsFishy)
			return "redirect:/user/addVac";

		PetVaccinationRecord vaccination = new PetVaccinationRecord();
		vaccination.setVacDate(d);
		vaccination.setWeight(weight);
		vaccination.setVet(vet);
		vaccination.setVacs(EnumTool.getEnumInt(pet.getSpecies(), vacs));
		vaccination.setPet(pet); // TODO

		myService.add(vaccination);
		return "redirect:/user/homepage";
	}

	@ModelAttribute
	public void commonAttr(@PathVariable("pid") String pidStr,
			HttpServletRequest request, Model model) {
		String uidStr = (String) request.getAttribute("uid");
		int uid = Integer.parseInt(uidStr);
		model.addAttribute("uid", uidStr);

		if (null == user || user.getUid() != uid) {
			user = myService.getById(User.class, uid);
		}

		int pid = Integer.parseInt(pidStr);

		if (null == pet || pet.getPid() != pid) {
			pet = myService.getById(Pet.class, pid);
		}

		if (pet == null || pet.getUser().getUid() != uid) {
			throw new FatalBeanException("Sth fishy in AddVacCtrl");
		}
	}
}