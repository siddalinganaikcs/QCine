package com.qcine.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.qcine.model.entity.User;
import com.qcine.user.service.EditUserProfileInter;

@Controller
@RestController
public class EditUserProfileController 
{
   @Autowired
   private EditUserProfileInter edituserprofileinter;
   
   @GetMapping("userprofile")
   ResponseEntity<Object> userProfile(@RequestHeader String email)
   {
	               Object eup = edituserprofileinter.userProfile(email);
	               if(!eup.equals("User profile is not found"))
	               {
	            	   return ResponseEntity.status(200).body(eup);
	               }
	               return ResponseEntity.status(400).body(eup);
   }
   
   
   @PutMapping("usereditprofile")
   ResponseEntity<Object> userEditProfile(@RequestBody User email)
   {
	               Object eup = edituserprofileinter.editUserProfile(email);
	               if(!eup.equals("User Profile Not Updating pls try again"))
	               {
	            	   return ResponseEntity.status(200).body(eup);
	               }
	               return ResponseEntity.status(400).body(eup);
   }
}
