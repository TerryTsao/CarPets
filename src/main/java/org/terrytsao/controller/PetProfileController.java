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
import org.terrytsao.model.Pet;
import org.terrytsao.model.Species;
import org.terrytsao.model.petGender;
import org.terrytsao.service.MyService;
import org.terrytsao.service.UserService;

@Controller
public class PetProfileController {
	@Autowired
	private UserService userService;


	@Autowired
	// private PetService petService;
	private MyService<Pet> service;

	@RequestMapping("/user/addPet")
	public ModelAndView addPetForm(@RequestParam Map<String, String> params) {
		ModelAndView mv = new ModelAndView("addPet");
		for (Map.Entry<String, String> entry : params.entrySet()) {
			String key = entry.getKey();
			String val = entry.getValue();

			mv.addObject(key, val);
		}
		return mv;
	}

	@RequestMapping(value = "/user/addPetProcess", method = RequestMethod.POST)
	public String processAddPetForm(@RequestParam Map<String, String> params,
			RedirectAttributes ra) {
		boolean sthIsEmpty = false;
		String petName = params.get("petName");
		String DOB = params.get("DOB"); // TODO calendar
		String species = params.getOrDefault("species", "");
		String gender = params.getOrDefault("gender", "");
		String microchipNO = params.get("microchipNO");
		String breed = params.get("breed");
		String ownerName = params.get("ownerName");

		if (0 == petName.length()){
			ra.addAttribute("petNameIsEmpty", "true");
			sthIsEmpty = true;
		}
		if (0 == DOB.length()){
			ra.addAttribute("DOBIsEmpty", "true");
			sthIsEmpty = true;
		}
		if (0 == species.length()){
			ra.addAttribute("speciesIsEmpty", "true");
			sthIsEmpty = true;
		}
		if (0 == gender.length()){
			ra.addAttribute("genderIsEmpty", "true");
			sthIsEmpty = true;
		}
		if (sthIsEmpty)
			return "redirect:/user/addPet";
		Pet pet = new Pet();
		pet.setPetName(petName);
		pet.setDOB(new Date()); // TODO
		pet.setSpecies(Species.valueOf(species.toUpperCase()));
		pet.setGender(petGender.valueOf(gender.toUpperCase()));
		pet.setMicrochipNO(microchipNO);
		pet.setBreed(breed);
		pet.setOwnerName(ownerName);
		pet.setUser(userService.getUser("maomao")); // TODO
		
		service.add(pet);
		return "redirect:/homepage";
	}
}
