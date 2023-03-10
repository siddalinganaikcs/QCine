package com.qcine.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.qcine.model.entity.User;
import com.qcine.user.service.UserServiceInter;

@Controller
@RestController
public class UserController 
{
	
	@Autowired
	private UserServiceInter userservice;
	
	@PostMapping(value="signup")
	ResponseEntity<Object> saveUser(@RequestBody User user)
	{
		Object us = userservice.saveUser(user);
		
		if(us instanceof User)
		{
			return ResponseEntity.status(200).body("Successefully SignUp Done");
		}
		return ResponseEntity.status(400).body(userservice.saveUser(user));
	}
	
	
	@GetMapping(value="login")
	ResponseEntity<Object> userLogin(@RequestHeader String  email , @RequestHeader String password)
	{
		     Object uu = userservice.userLogin(email, password);
		       System.out.println(email+" "+password+" "+uu+":   controller qcine");
		       
		  if(!uu.equals("user : Inavaled Email or Password")) 
		  {
				return ResponseEntity.status(200).body(uu);
			}
			return ResponseEntity.status(400).body(userservice.userLogin(email, password));
	}
	
	
	@PutMapping(value="forgetpassword")
	ResponseEntity<Object> userForgetPass(@RequestHeader String  email,@RequestHeader String password,@RequestHeader String conformpassword)
	{
		Object fp = userservice.userForgetPassword(email, password, conformpassword);
		if(fp instanceof User)
		{
			return ResponseEntity.status(200).body("password successefully updated");
		}
		return ResponseEntity.status(400).body(userservice.userForgetPassword(email, password, conformpassword));
		
	}



}
