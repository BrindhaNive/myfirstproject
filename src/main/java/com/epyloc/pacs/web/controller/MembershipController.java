package com.epyloc.pacs.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.epyloc.pacs.constants.MembershipOptionsEnum;
import com.epyloc.pacs.service.PacsService;
import com.epyloc.pacs.web.commandform.AddMemberCommandForm;
import com.epyloc.pacs.web.values.MasterValueOptions;

@Controller
public class MembershipController {

	@Autowired
	PacsService pacsService;

	private static final Logger logger = Logger.getLogger(MembershipController.class);

	@RequestMapping(value = "/membership", method = RequestMethod.GET)
	public ModelAndView membership() {
		logger.debug("Inside new Member");
		logger.info("Inside new Member");
		ModelAndView model = new ModelAndView();
		AddMemberCommandForm addMemberCommandForm = new AddMemberCommandForm();
		model.addObject("addMemberCommandForm", addMemberCommandForm);
		Map<Integer, MasterValueOptions> valueOptions = pacsService.fetchoptions(generateRequiredFieldList());
		if(valueOptions.size()>0){
		generateFeildsOptions(valueOptions, model);
		}
		model.setViewName("membership");
		return model;

	}

	private List<String> generateRequiredFieldList() {
		List<String> requiredFields = new ArrayList<>();
		requiredFields.add(MembershipOptionsEnum.MEMBERTYPE.getValue());
		requiredFields.add(MembershipOptionsEnum.SALUTATION.getValue());
		requiredFields.add(MembershipOptionsEnum.GENDER.getValue());
		requiredFields.add(MembershipOptionsEnum.STAFF.getValue());
		requiredFields.add(MembershipOptionsEnum.SENIORCITIZEN.getValue());
		requiredFields.add(MembershipOptionsEnum.PROOF.getValue());
		requiredFields.add(MembershipOptionsEnum.OCCUPATION.getValue());
		requiredFields.add(MembershipOptionsEnum.RELIGION.getValue());
		requiredFields.add(MembershipOptionsEnum.CATEGORY.getValue());
		requiredFields.add(MembershipOptionsEnum.TOF.getValue());
		return requiredFields;
	}

	private void generateFeildsOptions(Map<Integer, MasterValueOptions> valueOptions, ModelAndView model) {
		Map<Integer, String> memberTypeMap = new HashMap<>();
		Map<Integer, String> salutationMap = new HashMap<>();
		Map<Integer, String> genderMap = new HashMap<>();
		Map<Integer, String> staffMap = new HashMap<>();
		Map<Integer, String> seniorCitizenMap = new HashMap<>();
		Map<Integer, String> proofMap = new HashMap<>();
		Map<Integer, String> occupationMap = new HashMap<>();
		Map<Integer, String> religionMap = new HashMap<>();
		Map<Integer, String> categoryMap = new HashMap<>();
		Map<Integer, String> typeOfFarmerMap = new HashMap<>();

		for (Entry<Integer, MasterValueOptions> options : valueOptions.entrySet()) {
			if (options.getValue().getMstrTypecode() == MembershipOptionsEnum.MEMBERTYPE.getCode()) {
				memberTypeMap.put(options.getKey(), options.getValue().getDescription());
			}

			if (options.getValue().getMstrTypecode() == MembershipOptionsEnum.SALUTATION.getCode()) {
				salutationMap.put(options.getKey(), options.getValue().getDescription());
			}

			if (options.getValue().getMstrTypecode() == MembershipOptionsEnum.GENDER.getCode()) {
				genderMap.put(options.getKey(), options.getValue().getDescription());
			}
			
			if (options.getValue().getMstrTypecode() == MembershipOptionsEnum.STAFF.getCode()) {
				staffMap.put(options.getKey(), options.getValue().getDescription());
			}
			
			if (options.getValue().getMstrTypecode() == MembershipOptionsEnum.SENIORCITIZEN.getCode()) {
				seniorCitizenMap.put(options.getKey(), options.getValue().getDescription());
			}
			
			if (options.getValue().getMstrTypecode() == MembershipOptionsEnum.PROOF.getCode()) {
				proofMap.put(options.getKey(), options.getValue().getDescription());
			}
			
			if (options.getValue().getMstrTypecode() == MembershipOptionsEnum.OCCUPATION.getCode()) {
				occupationMap.put(options.getKey(), options.getValue().getDescription());
			}

			if (options.getValue().getMstrTypecode() == MembershipOptionsEnum.RELIGION.getCode()) {
				religionMap.put(options.getKey(), options.getValue().getDescription());
			}

			if (options.getValue().getMstrTypecode() == MembershipOptionsEnum.CATEGORY.getCode()) {
				categoryMap.put(options.getKey(), options.getValue().getDescription());
			}
			
			if (options.getValue().getMstrTypecode() == MembershipOptionsEnum.TOF.getCode()) {
				typeOfFarmerMap.put(options.getKey(), options.getValue().getDescription());
			}
			
		}
		
		model.addObject("memberTypeMap", memberTypeMap);
		model.addObject("salutationMap", salutationMap);
		model.addObject("genderMap", genderMap);
		model.addObject("staffMap", staffMap);
		model.addObject("seniorCitizenMap", seniorCitizenMap);
		model.addObject("proofMap", proofMap);
		model.addObject("occupationMap", occupationMap);
		model.addObject("religionMap", religionMap);
		model.addObject("categoryMap", categoryMap);
		model.addObject("typeOfFarmerMap", typeOfFarmerMap);

	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String processRegistration(@Valid AddMemberCommandForm member, BindingResult result, ModelMap model) {
		System.out.println("jnfdfnaisnfianfiasfuh");
		if (result.hasErrors()) {
			return "membership";
		}
		return "registrationSuccess";
	}

}
