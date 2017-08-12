package org.terrytsao.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.terrytsao.model.Pet;
import org.terrytsao.model.User;
import org.terrytsao.service.UserService;

@Controller
@RequestMapping("/user")
public class UserDashBoardController {

	@Autowired
	private UserService userService;

	private User user;

	@RequestMapping("homepage")
	public ModelAndView dashBoard() {
		ModelAndView mv = new ModelAndView("dashboard");

		Set<Pet> myPets = userService.getPetsById(user.getUid());
		mv.addObject("myPets", myPets);
		return mv;
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
