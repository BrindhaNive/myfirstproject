package com.epyloc.pacs.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.epyloc.pacs.constants.AcctTypeEnum;
import com.epyloc.pacs.util.CacheUtil;
import com.epyloc.pacs.web.commandform.FDCommandForm;

@Controller
@SessionAttributes({ "baseCommandForm", "fdCommandForm" })
public class FixedDepositController {

	private static final Logger logger = Logger.getLogger(FixedDepositController.class);

	@RequestMapping(value = "/deposit", method = RequestMethod.GET)
	public ModelAndView depositPage() {
		logger.debug("Inside Create Deposit");
		ModelAndView model = new ModelAndView();
		FDCommandForm fdCommandForm = new FDCommandForm();
		fdCommandForm.createNewFDDepositBean();
		model.addObject("fdCommandForm", fdCommandForm);
		model.addObject("schemeTypeMap", CacheUtil.getSchemeMapByAcctTypeEnum(AcctTypeEnum.FIXED_DEPOSIT));
		model.setViewName("deposit");
		return model;

	}

}