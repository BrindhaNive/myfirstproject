package com.epyloc.pacs.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.epyloc.pacs.manager.PACSCommonManager;
import com.epyloc.pacs.web.commandform.BaseCommandForm;

@Controller
@SessionAttributes("baseCommandForm")
public class LoginController {

	private static final Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	PACSCommonManager pacsCommonManager;

	@RequestMapping(value = "/landing", method = RequestMethod.GET)
	public ModelAndView defaultPage() {

		ModelAndView mv = new ModelAndView();

		BaseCommandForm baseCommandForm = new BaseCommandForm();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		logger.debug("name:" + username);
		baseCommandForm.setPacsPortalUser(pacsCommonManager.getuserDetails(username));
		mv.setViewName("landing");
		mv.addObject("baseCommandForm", baseCommandForm);
		return mv;

	}

	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView login(@RequestParam(value = "error", required = false) String error, @RequestParam(value = "logout", required = false) String logout) {

		logger.debug("Inside error:" + error);
		logger.debug("logout:" + logout);
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}

		model.setViewName("login");
		logger.debug("outside Login");
		return model;

	}

	// for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();

		// check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);

			model.addObject("username", userDetail.getUsername());

		}

		model.setViewName("403");
		return model;

	}

}