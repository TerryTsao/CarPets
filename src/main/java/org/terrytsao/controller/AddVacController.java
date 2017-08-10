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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.terrytsao.model.CatVac;
import org.terrytsao.model.DogVac;
import org.terrytsao.model.Pet;
import org.terrytsao.model.PetVaccinationRecord;
import org.terrytsao.model.VacArr;
import org.terrytsao.service.MyService;
import org.terrytsao.tool.DateTool;
import org.terrytsao.tool.EnumTool;

@Controller
public class AddVacController {
	@Autowired
	@Qualifier("myService")
	private MyService myService;

	@RequestMapping("/user/addVac")
	public ModelAndView addVacForm(@RequestParam Map<String, String> params) {
		ModelAndView mv = new ModelAndView("addVac", "vac",
				new VacArr());
		for (Map.Entry<String, String> entry : params.entrySet()) {
			String key = entry.getKey();
			String val = entry.getValue();

			mv.addObject(key, val);
		}
		// TODO
		Pet pet = myService.getById(Pet.class, 22);
		mv.addObject("petType", pet.getSpecies().toString());

		switch (pet.getSpecies()) {
			case CAT :
				mv.addObject("vacList", EnumTool.getEnumValues(CatVac.class));
				break;
			case DOG :
				mv.addObject("vacList", EnumTool.getEnumValues(DogVac.class));
				break;
			default :
				throw new FatalBeanException("Fatal error here!!!");
		}

		return mv;
	}

	@RequestMapping(value = "/user/addVacProcess", method = RequestMethod.POST)
	public String processAddVacForm(
			@ModelAttribute("vac") VacArr vacArr,
			@RequestParam Map<String, String> params, RedirectAttributes ra) {
		Pet pet = myService.getById(Pet.class, 22);
		String date = params.get("vacDate");
		String weight = params.get("weight");
		String vet = params.get("vet");
		String[] vacs = vacArr.getVacs();

		if (0 == date.length()) {
			ra.addAttribute("dateIsEmpty", "true");
			return "redirect:/user/addVac";
		}

		if (0 == vacs.length) {
			ra.addAttribute("vacsIsEmpty", "true");
			return "redirect:/user/addVac";
		}

		Date d = DateTool.isDateFormatted(date);
		if (d == null) {
			ra.addAttribute("dateWrongFormat", "true");
			return "redirect:/user/addVac";
		}

		PetVaccinationRecord vaccination = new PetVaccinationRecord();
		vaccination.setVacDate(d);
		vaccination.setWeight(Double.parseDouble(weight));
		vaccination.setVet(vet);
		vaccination.setVacs(EnumTool.getEnumInt(pet.getSpecies(), vacs));
		// vaccination.setDogVacs(DogVac.valueOf(dogvac.toUpperCase()));
		// vaccination.setCatvacs(CatVac.valueOf(catvac.toUpperCase()));
		vaccination.setPet(pet); // TODO

		myService.add(vaccination);
		return "redirect:/user/homepage";
	}

	@ModelAttribute
	public void commonAttr(HttpServletRequest request, Model model) {
		model.addAttribute("uid", request.getAttribute("uid"));
	}

}
