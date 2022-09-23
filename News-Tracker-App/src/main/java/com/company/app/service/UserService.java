package com.company.app.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.company.app.dto.UserRegistrationDto;
import com.company.app.entity.User;


public interface UserService extends UserDetailsService  {
	
	User save(UserRegistrationDto registrationDto);
}