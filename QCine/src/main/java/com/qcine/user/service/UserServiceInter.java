package com.qcine.user.service;

import com.qcine.model.entity.User;

public interface UserServiceInter 
{
	public Object saveUser(User ue);
	
	public Object userLogin(String email,String password);
	
	public Object userForgetPassword(String email,String password,String conformPass);
	
	

}
