package org.terrytsao.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.terrytsao.model.Vaccination;
import org.terrytsao.service.MyService;
import org.terrytsao.service.PetService;

@Controller
public class AddVacController {
	@Autowired
	private PetService petService;
	@Autowired
	private MyService<Vaccination> myService;

	@RequestMapping("/user/addVac")
	public ModelAndView addVacForm(@RequestParam Map<String, String> params) {
		ModelAndView mv = new ModelAndView("addVac");
		for (Map.Entry<String, String> entry : params.entrySet()) {
			String key = entry.getKey();
			String val = entry.getValue();

			mv.addObject(key, val);
		}
		return mv;
	}

	@RequestMapping(value = "/user/addVacProcess", method = RequestMethod.POST)
	public String processAddVacForm(@RequestParam Map<String, String> params,
			RedirectAttributes ra) {
		String date = params.get("vacDate");
		String weight = params.get("weight");
		String vet = params.get("vet");
		String dogvac = params.getOrDefault("dogvac", "");
		String catvac = params.getOrDefault("catva", "");

		if (0 == date.length()) {
			ra.addAttribute("dateIsEmpty", "true");
			return "redirect:/user/addVac";
		}

		Vaccination vaccination = new Vaccination();
		vaccination.setVacDate(new Date());
		vaccination.setWeight(Double.parseDouble(weight));
		vaccination.setVet(vet);
		// vaccination.setDogvac(DogVac.valueOf(dogvac.toUpperCase()));
		// vaccination.setCatvac(CatVac.valueOf(catvac.toUpperCase()));
		vaccination.setPet(petService.getById(1)); // TODO

		myService.add(vaccination);
		return "redirect:/homepage";
	}
}
