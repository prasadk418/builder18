package com.builder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.builder.domain.User;
import com.builder.repository.RegisterRepository;
@Service
public class RegisterServiceImpl {

	@Autowired
	private RegisterRepository registerRepo;
	
	public boolean registerUser(User user)
	{
		boolean status=false;
		User u=registerRepo.save(user);
		if(u!=null)
			status=true;
		
		return status; 
	}
	
}
