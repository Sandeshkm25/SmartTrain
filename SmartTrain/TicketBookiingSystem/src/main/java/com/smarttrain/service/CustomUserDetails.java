package com.smarttrain.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.smarttrain.entity.User;

public class CustomUserDetails  implements UserDetails{

	 private final User user;

	
	    public CustomUserDetails(User user) {
	        this.user = user;
	    }

	    public User getUser() {
	        return user;
	    }

	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        return Collections.singletonList(
	            new SimpleGrantedAuthority("ROLE_" + user.getRole().name())
	        );
	    }

	    @Override
	    public String getPassword() {
	        return user.getPassword();
	    }

	    @Override
	    public String getUsername() {
	        return user.getEmail(); // or user.getUsername() if you prefer
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
