package com.epyloc.pacs.web.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.epyloc.pacs.constants.MembershipOptionsEnum;
import com.epyloc.pacs.service.MembershipService;
import com.epyloc.pacs.web.commandform.AddMemberCommandForm;
import com.epyloc.pacs.web.values.MasterValueOptions;

@Controller
public class MembershipController {

	@Autowired
	MembershipService membershipService;

	private static final Logger logger = Logger.getLogger(MembershipController.class);

	@RequestMapping(value = "/membership", method = RequestMethod.GET)
	public String membership(Model model) {
		logger.info("jhv Inside new Member");
		if (!model.containsAttribute("addMemberCommandForm")) {
			model.addAttribute("addMemberCommandForm", new AddMemberCommandForm());
		}
		Map<Integer, MasterValueOptions> valueOptions = membershipService.fetchoptions(generateRequiredFieldList());
		if (valueOptions.size() > 0) {
			generateFeildsOptions(valueOptions, model);
		}
		return "membership";

	}

	@RequestMapping(value = "/membership", method = RequestMethod.POST)
	public String processRegistration(@Valid  AddMemberCommandForm addMemberCommandForm, BindingResult result, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			logger.info("agedgadgagaggyfufuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuujjjjjjjjjjjjjjjjjjjjjjjjjjjjjjffffffffffffff");
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addMemberCommandForm", result);
            redirectAttributes.addFlashAttribute("addMemberCommandForm", addMemberCommandForm);
            
            return "redirect:/membership";
		}
		BigInteger b = new BigInteger("8988999979879");
		addMemberCommandForm.setMembershipId(b);
		logger.info(addMemberCommandForm.toString());
		try {
			membershipService.insertMembershipdetails(addMemberCommandForm);
			if (addMemberCommandForm.getGeneratedId() != null) {
				logger.info("Generated Id" + addMemberCommandForm.getGeneratedId());
			} else {
				logger.info("Id is Null");
			}
		} catch (Exception e) {
			logger.info("Exception::" + e.getMessage() + " 712- HHHHHHHHH");
			e.printStackTrace();
		}
		return "registrationSuccess";
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
		requiredFields.add(MembershipOptionsEnum.TOS.getValue());
		return requiredFields;
	}

	private void generateFeildsOptions(Map<Integer, MasterValueOptions> valueOptions, Model model) {
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
		Map<Integer, String> typeOfShareMap = new HashMap<>();
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
			if (options.getValue().getMstrTypecode() == MembershipOptionsEnum.TOS.getCode()) {
				typeOfShareMap.put(options.getKey(), options.getValue().getDescription());
			}
		}

		model.addAttribute("memberTypeMap", memberTypeMap);
		model.addAttribute("salutationMap", salutationMap);
		model.addAttribute("genderMap", genderMap);
		model.addAttribute("staffMap", staffMap);
		model.addAttribute("seniorCitizenMap", seniorCitizenMap);
		model.addAttribute("proofMap", proofMap);
		model.addAttribute("occupationMap", occupationMap);
		model.addAttribute("religionMap", religionMap);
		model.addAttribute("categoryMap", categoryMap);
		model.addAttribute("typeOfFarmerMap", typeOfFarmerMap);
		model.addAttribute("typeOfShareMap", typeOfShareMap);
	}
}
