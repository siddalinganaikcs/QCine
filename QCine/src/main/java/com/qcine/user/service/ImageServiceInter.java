package com.qcine.user.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.qcine.model.entity.Image;

public interface ImageServiceInter 
{
	public Object saveImage(MultipartFile file) throws IOException;
	
	public Object downloadImage();
	

}
