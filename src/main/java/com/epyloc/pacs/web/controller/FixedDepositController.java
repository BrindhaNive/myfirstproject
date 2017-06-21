package com.epyloc.pacs.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.epyloc.pacs.constants.AcctTypeEnum;
import com.epyloc.pacs.manager.PACSCommonManager;
import com.epyloc.pacs.util.CacheUtil;
import com.epyloc.pacs.web.commandform.BaseCommandForm;
import com.epyloc.pacs.web.commandform.FDCommandForm;
import com.epyloc.pacs.web.values.FdMembershipDetails;

@Controller
@SessionAttributes({ "baseCommandForm", "fdCommandForm" })
public class FixedDepositController {

	private static final Logger logger = Logger.getLogger(FixedDepositController.class);

	@Autowired
	PACSCommonManager pacsCommonManager;

	@RequestMapping(value = "/deposit", method = RequestMethod.GET)
	public ModelAndView depositPage() {
		logger.debug("Inside Create Deposit");
		ModelAndView model = new ModelAndView();
		FDCommandForm fdCommandForm = new FDCommandForm();
		fdCommandForm.createNewFDDepositBean();
		fdCommandForm.getFdAmountDetails().setRateOfInterest("9.5");
		model.addObject("fdCommandForm", fdCommandForm);
		model.addObject("schemeTypeMap", CacheUtil.getSchemeMapByAcctTypeEnum(AcctTypeEnum.FIXED_DEPOSIT));
		model.setViewName("deposit");
		return model;

	}

	@RequestMapping(value = "/fdsubmit", method = RequestMethod.POST)
	public String fdsubmit(@ModelAttribute("fdCommandForm") FDCommandForm fdCommandForm, @ModelAttribute("baseCommandForm") BaseCommandForm baseCommandForm, ModelMap modelMap, BindingResult result) {
		logger.debug("Inside submit Deposit:" + fdCommandForm);
		pacsCommonManager.persistFDDetails(fdCommandForm, baseCommandForm.getPacsPortalUser());
		return "depositsuccess";
	}

	@RequestMapping(value = "/getmembershipsuggestion", method = RequestMethod.GET)
	public @ResponseBody List<FdMembershipDetails> getmembershipsuggestion(@RequestParam String searchValue) {
		logger.debug("searchValue:" + searchValue);
		return pacsCommonManager.getMemSuggestions(searchValue);
	}

	@RequestMapping(value = "/getFdTxnDtls", method = RequestMethod.POST)
	public @ResponseBody String getFdTxnDtls(@ModelAttribute("fdCommandForm") FDCommandForm fdCommandForm) {
		logger.debug("fdCommandForm:" + fdCommandForm);
		pacsCommonManager.processFDTxnDetails(fdCommandForm);
		logger.debug("fdCommandForm after:" + fdCommandForm);
		ObjectWriter ow= new ObjectMapper().writer().withDefaultPrettyPrinter();
		String jsonInString = "";
		try {
			jsonInString = ow.writeValueAsString(fdCommandForm.getFdTxnDet());
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("jsonInString:" + jsonInString);
		return jsonInString;
	}

	@RequestMapping(value = "/getroibyschemeid", method = RequestMethod.POST)
	public String generateSecretCode(@ModelAttribute("fdCommandForm") FDCommandForm fdCommandForm, HttpServletResponse response) {
		logger.debug("Entering ");
		try {
			Integer schmeTypeID = fdCommandForm.getSelectedFdSchemeTypeId();
			logger.debug("schmeTypeID: " + schmeTypeID);
			String roi = pacsCommonManager.getSchemeROIbyType(schmeTypeID);
			logger.debug("roi: " + roi);
			JSONObject jsonObj = new JSONObject();

			jsonObj.put("roi", roi);
			logger.debug("jsonObj: " + jsonObj.toString());
			response.setContentType("application/json");
			response.getWriter().write(jsonObj.toString());

		} catch (Exception e) {
			logger.error("error during JSON retrieval", e);
		}
		return null;
	}
}