package org.terrytsao.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.terrytsao.model.User;
import org.terrytsao.service.UserService;
import org.terrytsao.tool.PasswordTool;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public ModelAndView hello() {
		return new ModelAndView("index");
	}

	@RequestMapping("/homepage")
	public ModelAndView home(@ModelAttribute("username") String name) {
		ModelAndView mv = new ModelAndView("homepage");

		mv.addObject("username", name);

		return mv;
	}

	@RequestMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}

	@RequestMapping("/signup")
	public ModelAndView signup(@ModelAttribute("userName") String name) {
		ModelAndView mv = new ModelAndView("signup");
		if (name != null) {
			mv.addObject("userName", name);
		}
		return mv;
    }

	@RequestMapping(value="/signupProcess", method=RequestMethod.POST)
	public String process(@RequestParam Map<String, String> params,
			RedirectAttributes ra) {
		String userName = params.get("userName");
		String passwd = params.get("password");
			String passwd1 = params.get("password1");
		if (isUserNameDup(userName)) { // dup username
			ra.addAttribute("userName", userName);
			return "redirect:/signup";
		}
		else{
			// check if two passwords matches
			if (null == passwd || null == passwd1) {
				throw new NullPointerException("Either password is null");
			}

			if (!passwd.equals(passwd1) || passwd.length() < 6) { // password
																	// inputs
																	// mismatch
				ra.addAttribute("userName", userName);
				return "redirect:/signup";
			}
			else { // all input passes
					// encrypt password
				String hashedPW = PasswordTool.hashpw(passwd);

				User user = new User();
				user.setUserName(userName);
				user.setPassword(hashedPW);

                userService.addUser(user);

				ra.addFlashAttribute("username", userName);
				return "redirect:/homepage";
			}
		}
	}

	/**
	 * Check if userName is already in the db.
	 */
	private boolean isUserNameDup(String userName) {
		return userService.getUser(userName) != null;
	}
}
