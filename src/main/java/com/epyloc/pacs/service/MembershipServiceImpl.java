package com.epyloc.pacs.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epyloc.pacs.mappers.MembershipMapper;
import com.epyloc.pacs.web.commandform.AddMemberCommandForm;
import com.epyloc.pacs.web.values.MasterValueOptions;

@Component
public class MembershipServiceImpl implements MembershipService {

	@Autowired(required = false)
	MembershipMapper mapper;

	@Override
	public Map<Integer, MasterValueOptions> fetchoptions(List<String> requiredFields) {
		Map<Integer, MasterValueOptions> membershipOptions = new HashMap<>();
		membershipOptions = mapper.fetchoptions(requiredFields);
		return membershipOptions;
	}

	@Override
	public void insertMembershipdetails(AddMemberCommandForm addMemberCommandForm) throws Exception {
		mapper.insertMembershipdetails(addMemberCommandForm);
	}

}
