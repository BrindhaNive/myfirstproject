package com.epyloc.pacs.constants;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.epyloc.pacs.web.controller.MembershipController;

public class Test {
	private static final Logger logger = Logger.getLogger(MembershipController.class);

	public enum Company {
		MEMBER_TYPE("MEMBER TYPE", 1), SALUTATION("SALUTATION", 2), GENDER("GENDER", 3), STAFF("STAFF", 4), SENIOR_CITIZEN("SENIOR CITIZEN", 5), PROOF("PROOF", 6), OCCUPATION("OCCUPATION", 7), RELIGION("RELIGION", 8), CATEGORY("CATEGORY",
				9), TYPE_OF_FARMER("TYPE_OF_FARMER", 10);
		private String value;
		private int code;

		private Company(String value, int code) {
			this.value = value;
			this.code = code;
		}
		
		
	}

	public static void main(String[] args) {
Map<Integer, String> m = new HashMap<>();
m.put(1, "value");
System.out.println(m.size());	}
}
