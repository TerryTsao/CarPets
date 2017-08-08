package org.terrytsao.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.terrytsao.model.Pet;
import org.terrytsao.service.Service;

@Controller
public class PetProfileController {

	@Autowired
	// private PetService petService;
	private Service<Pet> service;

	@RequestMapping("/user/addPet")
	public ModelAndView addPetForm(@RequestParam Map<String, String> params) {
		return new ModelAndView("addPet");
	}

	@RequestMapping("/user/addPetProcess")
	public String processAddPetForm(@RequestParam Map<String, String> params) {
		System.out.println(params);
		return "homepage";
	}
}
