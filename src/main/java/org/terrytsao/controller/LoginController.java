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
	public ModelAndView signup() {
		return new ModelAndView("signup");
    }

	@RequestMapping(value="/signupProcess", method=RequestMethod.POST)
	public String process(@RequestParam Map<String, String> params,
			RedirectAttributes ra) {
		if (true) {
			// check if two passwords matches
			String passwd = params.get("password");
			String passwd1 = params.get("password1");

			if (null == passwd || null == passwd1) {
				throw new NullPointerException("Either password is null");
			}

			if (!passwd.equals(passwd1) || passwd.length() < 3) { // password inputs mismatch
				ra.addAttribute("username", params.get("username"));
				return "redirect:/signup";
			}
			else { // all input passes
				// TODO: process and store to database
				User user = new User();
                user.setUid(17);
				user.setUserName(params.get("username"));
				user.setPassword(passwd);

                /*
				SessionFactory sf = new Configuration().configure()
						.buildSessionFactory();
				Session sss = sf.openSession();
				Transaction tx = sss.beginTransaction();
				sss.save(user);
				tx.commit();
				sss.close();
                */
                userService.addUser(user);

				ra.addFlashAttribute("username", params.get("username"));
				return "redirect:/homepage";
			}
		}
		return null;

	}
}
