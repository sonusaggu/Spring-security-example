package com.saggu.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import com.saggu.models.user;

@Repository
public interface LoginDAO extends CrudRepository<user, Integer>{
	
	
	user findByUsernameAndPassword(@Param("username") String username,
            @Param("password") String password);

	user findByUsername(String username);
}
