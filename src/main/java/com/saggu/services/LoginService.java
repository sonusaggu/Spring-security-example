package com.saggu.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saggu.models.user;
import com.saggu.respository.LoginDAO;
@Service
public class LoginService {

	@Autowired
	private LoginDAO loginDao;
	
	public user registerUser(user u) {
		
		return loginDao.save(u);
		
	}
	
	public user findUser(user u) {
		try {
			user r=loginDao.findByUsernameAndPassword(u.getUsername(), u.getPassword());
			return r;
		}
		catch(NullPointerException e) {
			return null;
		}
		
		
	}
}
