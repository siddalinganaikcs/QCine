package com.qcine.user.serviceimpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.qcine.model.entity.User;
import com.qcine.user.exception.UserProfileNorUpdatedException;
import com.qcine.user.exception.UsreProfileNotFoundException;
import com.qcine.user.repository.UserRepoInter;
import com.qcine.user.service.EditUserProfileInter;

@Service
public class EditUserProfileImpl implements EditUserProfileInter
{
	@Autowired
     private UserRepoInter userrepointer;
	
	@Override
	public Object userProfile(String email) 
	{
	         User eup = userrepointer.findByUserLogin(email);
		if(eup!=null)
		{
			Map<Object,Object> map=new HashMap<Object,Object>();
			
			map.put("User_Name", eup.getUserName());
			map.put("User_Gender", eup.getUserGender());
			map.put("User_Age", eup.getUserAge());
			map.put("User_PhoneNo", eup.getUserPhoneNo());
			map.put("User_City", eup.getAddress().getCity());
			map.put("User_Country", eup.getAddress().getCountry());
			map.put("User_HouseNo", eup.getAddress().getHouseNo());
			map.put("User_state", eup.getAddress().getState());
			map.put("User_Street", eup.getAddress().getStreet());
			map.put("User_ZipCode", eup.getAddress().getZipCode());
			map.put("User_Intrested", eup.getAddress().getIntrested().getDiseces());
			return map;
		}
		else
		{
			try 
			{
				throw new UsreProfileNotFoundException(email);
			}
			catch(UsreProfileNotFoundException upn)
			{
				System.out.println(upn);
				return upn.getMessage();
			}
		}
	}

	@Override
	public Object editUserProfile(User email) 
	{
		  User li = userrepointer.findByUserLogin(email.getUserEmail());
	
		
		 if(li !=null)
		{
			 li.setUserName(email.getUserName());
			 li.setUserPhoneNo(email.getUserPhoneNo());
			 li.setUserAge(email.getUserAge());
			 li.setUserGender(email.getUserGender());
			 li.getAddress().setCity(email.getAddress().getCity());
			 li.getAddress().setCountry(email.getAddress().getCountry());
			 li.getAddress().setHouseNo(email.getAddress().getHouseNo());
			 li.getAddress().setState(email.getAddress().getState());
			 li.getAddress().setZipCode(email.getAddress().getZipCode());
			 li.getAddress().setStreet(email.getAddress().getStreet());
			 li.getAddress().getIntrested().setDiseces(email.getAddress().getIntrested().getDiseces());
			  
			 userrepointer.save(li);
			  
			
			 return li ;
			 
		 }
		 else
		 {
			   try {
					throw new UserProfileNorUpdatedException("User");
			   }
	       catch (UserProfileNorUpdatedException e)
	         {
					System.out.println(e);
					return e.getMessage();
			}
		 }
	
	}

}
