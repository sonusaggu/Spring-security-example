package com.saggu.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.saggu.models.CustomUserDetails;
import com.saggu.models.user;
import com.saggu.respository.LoginDAO;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private LoginDAO loginDao;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        user us = loginDao.findByUsername(username);
        CustomUserDetails cud=null;
        if(us!=null) {
        	cud=new CustomUserDetails();
        	cud.setU(us);
        }else {
        	throw new UsernameNotFoundException("not present");
        }
		return cud;
      
    }

  
}
