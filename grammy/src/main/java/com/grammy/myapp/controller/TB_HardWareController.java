package com.grammy.myapp.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grammy.myapp.config.jwt.JwtTokenProvider;
import com.grammy.myapp.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins="*")
public class TB_HardWareController {
	
	@GetMapping("/api/sensor")
	public String getSensor(String value) {
		System.out.println(value);
		return value;
	}
}
