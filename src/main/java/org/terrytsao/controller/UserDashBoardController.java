package org.terrytsao.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.terrytsao.model.User;
import org.terrytsao.service.MyService;

@Controller
@RequestMapping("/user")
public class UserDashBoardController {

	@Autowired
	private MyService myService;

	private User user;

	@RequestMapping("homepage")
	public ModelAndView dashBoard() {
		ModelAndView mv = new ModelAndView("dashboard");

		return mv;
	}

	@ModelAttribute
	public void commonAttr(HttpServletRequest request, Model model) {
		String uidStr = (String) request.getAttribute("uid");
		int uid = Integer.parseInt(uidStr);
		model.addAttribute("uid", uidStr);

		if (null == user || user.getUid() != uid) {
			user = myService.getById(User.class, uid);
		}
	}
}
