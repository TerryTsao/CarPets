package org.terrytsao.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.terrytsao.model.Pet;
import org.terrytsao.model.PetGender;
import org.terrytsao.model.Species;
import org.terrytsao.model.User;
import org.terrytsao.service.PetService;
import org.terrytsao.service.UserService;
import org.terrytsao.tool.DateTool;

@Controller
@RequestMapping("/user")
public class PetProfileController {
	@Autowired
	private UserService userService;

	@Autowired
	private PetService petService;

	private User user;

	@RequestMapping("/addPet")
	public ModelAndView addPetForm(@RequestParam Map<String, String> params) {
		ModelAndView mv = new ModelAndView("addPet");
		mv.addAllObjects(params);
		return mv;
	}

	@RequestMapping(value = "/addPetProcess", method = RequestMethod.POST)
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

		ra.addAllAttributes(params);
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
		Date date = DateTool.isDateFormatted(DOB);
		if (date == null) {
			ra.addAttribute("DOBWrongFormat", "true");
			return "redirect:/user/addPet";
		}

		Pet pet = new Pet();
		pet.setPetName(petName);
		pet.setDOB(date);
		pet.setSpecies(Species.valueOf(species.toUpperCase()));
		pet.setGender(PetGender.valueOf(gender.toUpperCase()));
		pet.setMicrochipNO(microchipNO);
		pet.setBreed(breed);
		pet.setOwnerName(ownerName);
		pet.setUser(userService.getUser("maomao")); // TODO
		
		petService.add(pet);
		return "redirect:/user/homepage";
	}

	@ModelAttribute
	public void commonAttr(HttpServletRequest request, Model model) {
		String uidStr = (String) request.getAttribute("uid");
		int uid = Integer.parseInt(uidStr);
		model.addAttribute("uid", uidStr);

		if (null == user || user.getUid() != uid) {
			user = userService.getById(User.class, uid);
		}
	}

}
