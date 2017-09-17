package com.epyloc.pacs.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.epyloc.pacs.web.commandform.AddMemberCommandForm;
import com.epyloc.pacs.web.values.MasterValueOptions;

@Service
public interface MembershipService {
	public Map<Integer, MasterValueOptions> fetchoptions(List<String> requiredFields);
	public void insertMembershipdetails(AddMemberCommandForm addMemberCommandForm) throws Exception;
}
