package com.qcine.user.serviceimpl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.qcine.model.entity.Image;
import com.qcine.user.exception.ImageFilleNotFoundException;
import com.qcine.user.exception.ImageNotUploaded;

import com.qcine.user.repository.ImageRepoInter;
import com.qcine.user.service.ImageServiceInter;
@Service
public class ImageServiceImpl implements ImageServiceInter
{
	@Autowired
	private ImageRepoInter imagerepo;

	@Override
	public Object saveImage(MultipartFile file) throws IOException 
	{
		Image image = imagerepo.save(Image.builder().image_Name(file.getOriginalFilename())
													.image_Type(file.getContentType())
													.image_Data(file.getBytes()).build());		
	
		if(image !=null)
		{
			 return imagerepo.save(image);
		}
		else
		{
			try
			{
				throw new ImageNotUploaded("image");
			}
			catch(ImageNotUploaded tt)
			{
				System.out.println(tt);
				return tt.getMessage();
			}
		}
		
	}

	@Override
	public Object downloadImage() 
	{
		List<Image> download =imagerepo.findAll();
	     
	     if(download !=null)
	     {
	    	 return download;
	     }
	     else
	     {
	    	 try
	    	 {
	    		 throw new ImageFilleNotFoundException("download");
	    	 }
	    	 catch(ImageFilleNotFoundException e)
	    	 {

	    		 return e.getMessage();
	    	 }
	     }
	}

}
