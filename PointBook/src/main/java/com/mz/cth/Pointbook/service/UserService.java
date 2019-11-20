package com.mz.cth.Pointbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mz.cth.Pointbook.interfaces.IUser;
import com.mz.cth.Pointbook.model.User;

@Service
public class UserService {

	
	@Autowired 
	IUser iuser;
	
	public boolean save(User user) {
		try {
			iuser.save(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	

	}
}
