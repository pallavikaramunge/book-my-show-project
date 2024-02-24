package com.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Dto.AuthenticateRequest;


import com.example.security.JwtUtil;
import com.example.security.MyUserDetailedService;


@RestController
@RequestMapping("/api/auth")
public class AuthenticationRestController {
	
	@Autowired
	MyUserDetailedService myUserDetailedService;

	@Autowired
	 AuthenticationManager authenticationManager;
	
	@Autowired
	 JwtUtil jwtUtil;
	
	@PostMapping("/login")
	public String authenticateUser(@RequestBody AuthenticateRequest request)throws Exception{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
			
		}catch(Exception e) {
			throw new Exception ("Invalid Credentials ");
		}
		
		UserDetails userDetails =	myUserDetailedService.loadUserByUsername(request.getUsername());
			
	    String token =	jwtUtil.generateToken(userDetails);
		return token;
	}
 
}


