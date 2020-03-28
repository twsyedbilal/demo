package com.techweaversys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techweaversys.security.AuthenticationRequest;
import com.techweaversys.service.UserService;



@RestController
public class WelcomeController {
	
	//change 
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/")
	public String Welcome() {		
		return "Welcome to AL Rizwan Application";
	}
	
	/*@GetMapping(value = "/mail")
	public String sendingMail(){
		mailService.sendMailTemplate("hr@techweaversys.com", "THIS HRM EMAIL TEMPLATE");
		return "Please check mailBox";
	}*/
	
	@PostMapping(value = "/login")
	public ResponseEntity<?> loginMethod(@RequestBody AuthenticationRequest authenticationRequest) {		
		return userService.authenticationUser(authenticationRequest);
	}

}
