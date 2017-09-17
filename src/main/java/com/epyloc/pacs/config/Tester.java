package com.epyloc.pacs.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Tester {

	public static void main(String[] args) {
		System.out.println("kjnka");
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		String p="12345";
		encoder.encode(p);
		encoder.hashCode();
		System.out.println(encoder.hashCode());
	}

}
