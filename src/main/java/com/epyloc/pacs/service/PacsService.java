package com.epyloc.pacs.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epyloc.pacs.mappers.MembershipMapper;
import com.epyloc.pacs.web.values.MembershipType;

@Component
public class PacsService {
	
	@Autowired(required=false)
	MembershipMapper mapper;
	

	public Map<Integer, String> fetchMemberTypes() {
		Map<Integer, MembershipType> memberTyes=new HashMap<>();
		memberTyes=mapper.fetchMemberTypes();
		Map<Integer,String> m = new HashMap<>();
		for (Map.Entry<Integer, MembershipType> entry : memberTyes.entrySet()) {
		    m.put(entry.getKey(), entry.getValue().getMemberTypeDesc());
		}
		return m;
	}

}
