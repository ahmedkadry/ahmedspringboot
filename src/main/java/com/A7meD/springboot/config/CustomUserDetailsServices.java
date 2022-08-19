package com.A7meD.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.A7meD.springboot.models.UserDtls;
import com.A7meD.springboot.repository.UserRepository;

public class CustomUserDetailsServices implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		try {
			UserDtls user = userRepository.findByEmail(email);
			if (user == null) {
				throw new UsernameNotFoundException("Not Found");
			} else {
				return new CustomUserDtls(user);
			}

		} catch (Exception e) {
			e.getMessage();
		}

		return null;
	}

}