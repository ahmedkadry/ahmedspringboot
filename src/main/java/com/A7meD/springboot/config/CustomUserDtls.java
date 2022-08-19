package com.A7meD.springboot.config;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.A7meD.springboot.models.UserDtls;

public class CustomUserDtls implements UserDetails {

	public CustomUserDtls(UserDtls userDtls) {
		this.userDtls = userDtls;
	}

	private static final long serialVersionUID = 1L;
	@Autowired
	private UserDtls userDtls;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		HashSet<SimpleGrantedAuthority> set = new HashSet<SimpleGrantedAuthority>();
		set.add(new SimpleGrantedAuthority(userDtls.getRole()));

		return set;
	}

	@Override
	public String getPassword() {
		return userDtls.getPassword();
	}

	@Override
	public String getUsername() {
		return userDtls.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
