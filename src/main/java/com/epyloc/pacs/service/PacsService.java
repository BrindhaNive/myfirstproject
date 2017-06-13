package com.epyloc.pacs.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epyloc.pacs.mappers.MembershipMapper;
import com.epyloc.pacs.web.values.Category;
import com.epyloc.pacs.web.values.Gender;
import com.epyloc.pacs.web.values.MasterValueOptions;
import com.epyloc.pacs.web.values.MembershipType;
import com.epyloc.pacs.web.values.Occupation;
import com.epyloc.pacs.web.values.Religion;
import com.epyloc.pacs.web.values.Salutation;

@Component
public class PacsService {

	@Autowired(required = false)
	MembershipMapper mapper;

	public Map<Integer, String> fetchMemberTypes() {
		Map<Integer, MembershipType> memberTyes = new HashMap<>();
		memberTyes = mapper.fetchMemberTypes();
		Map<Integer, String> m = new HashMap<>();
		for (Map.Entry<Integer, MembershipType> entry : memberTyes.entrySet()) {
			m.put(entry.getKey(), entry.getValue().getMemberTypeDesc());
		}
		return m;
	}

	public Map<Integer,  MasterValueOptions> fetchoptions(List<String> requiredFields ) {
		Map<Integer, MasterValueOptions> membershipOptions = new HashMap<>();
		membershipOptions = mapper.fetchoptions(requiredFields);
		return membershipOptions;
	}

	public Map<Integer, String> fetchGender() {
		Map<Integer, Gender> memberTyes = new HashMap<>();
		memberTyes = mapper.fetchGenderTypes();
		Map<Integer, String> m = new HashMap<>();
		for (Entry<Integer, Gender> entry : memberTyes.entrySet()) {
			m.put(entry.getKey(), entry.getValue().getGenderDesc());
		}
		return m;
	}

	public Map<Integer, String> fetchReligion() {
		Map<Integer, Religion> memberTyes = new HashMap<>();
		memberTyes = mapper.fetchReligion();
		Map<Integer, String> m = new HashMap<>();
		for (Entry<Integer, Religion> entry : memberTyes.entrySet()) {
			m.put(entry.getKey(), entry.getValue().getReligionDesc());
		}
		return m;
	}
	
	public Map<Integer, String> fetchCategory() {
		Map<Integer, Category> memberTyes = new HashMap<>();
		memberTyes = mapper.fetchCategory();
		Map<Integer, String> m = new HashMap<>();
		for (Entry<Integer, Category> entry : memberTyes.entrySet()) {
			m.put(entry.getKey(), entry.getValue().getCategoryDesc());
		}
		return m;
	}
	
	public Map<Integer, String> fetchOccupation() {
		Map<Integer, Occupation> memberTyes = new HashMap<>();
		memberTyes = mapper.fetchOccupation();
		Map<Integer, String> m = new HashMap<>();
		for (Entry<Integer, Occupation> entry : memberTyes.entrySet()) {
			m.put(entry.getKey(), entry.getValue().getOccupationDesc());
		}
		return m;
	}

}
