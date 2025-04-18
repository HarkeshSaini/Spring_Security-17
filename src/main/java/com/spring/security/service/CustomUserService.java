package com.spring.security.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.spring.security.entity.UserInfoDetail;
import com.spring.security.exception.NotFoundException;
import com.spring.security.repositories.UserInfoDetailRepositorie;

@Service
public class CustomUserService implements UserDetailsService {

	
    @Autowired
    private UserInfoDetailRepositorie detailRepositorie;

    @Override
	public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
		Optional<UserInfoDetail> costumUser = detailRepositorie.findByEmail(emailId);
		UserInfoDetail orElse = costumUser.orElse(null);
		if (ObjectUtils.isEmpty(orElse)) {
			throw new NotFoundException("User not found:- " + emailId);
		}
		Collection<? extends GrantedAuthority> authorities = orElse.getAuthorities();
		String password = orElse.getPassword();
		PasswordEncoder encoder=new BCryptPasswordEncoder(); 
		return User.builder().username(emailId).password(encoder.encode(password)).authorities(authorities).build();
	}
}
