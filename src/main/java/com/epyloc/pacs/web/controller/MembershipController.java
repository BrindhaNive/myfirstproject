package com.epyloc.pacs.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.epyloc.pacs.service.PacsService;
import com.epyloc.pacs.web.commandform.AddMemberCommandForm;

@Controller
public class MembershipController {
	
	@Autowired
	PacsService pacsService;

	private static final Logger logger = Logger.getLogger(FixedDepositController.class);

	@RequestMapping(value = "/newMember", method = RequestMethod.GET)
	public ModelAndView depositPage() {
		logger.debug("Inside new Member");
		ModelAndView model = new ModelAndView();
		AddMemberCommandForm addMemberCommandForm = new AddMemberCommandForm();
		model.addObject("addMemberCommandForm", addMemberCommandForm);
		model.addObject("memberTypeMap", pacsService.fetchMemberTypes());
		model.setViewName("membership");
		return model;

	}

}
