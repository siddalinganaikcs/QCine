package com.qcine.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.qcine.model.entity.Image;
import com.qcine.user.service.ImageServiceInter;

@Controller
@RestController
public class ImageController 
{
	@Autowired
	private ImageServiceInter imageinter;

	  @PostMapping(value="/upload", consumes= {MediaType.MULTIPART_FORM_DATA_VALUE})
	ResponseEntity<Object>  saveImage(@RequestParam ("upload")MultipartFile file) throws Exception
	{
		  Object ji = imageinter.saveImage(file) ;
		  if(ji instanceof Image)
		  {
			  return ResponseEntity.status(200).body("image uploaded successefully");
		  }
		  return ResponseEntity.status(400).body(ji);
	}
	
	  @GetMapping("/download")
	  ResponseEntity<Object>  dowlImage(MultipartFile file) throws Exception
		{
			  Object i = imageinter.downloadImage() ;
			  if(i instanceof Image)
			  {
				  return ResponseEntity.status(200).body("image download successefully");
			  }
			  return ResponseEntity.status(400).body(i);
		}
}
