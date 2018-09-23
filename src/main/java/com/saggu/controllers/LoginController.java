package com.saggu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saggu.models.user;
import com.saggu.services.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/user",method=RequestMethod.POST,produces = "application/json")
	public user checkUser(@RequestBody user u) {
		user res= loginService.findUser(u);
		return res;
	}
	@RequestMapping(value="/admin")
	public String checkAdmin() {
		
		return "Admin user";
	}
	@RequestMapping(value="/user")
	public String checkUser() {
		
		return "normal user";
	}
	
	@RequestMapping(value="/register" ,method=RequestMethod.POST,produces = "application/json")
	public user registerUser(@RequestBody user u) {
		
		
		user res= loginService.registerUser(u);
		
		return res;
	}
}
