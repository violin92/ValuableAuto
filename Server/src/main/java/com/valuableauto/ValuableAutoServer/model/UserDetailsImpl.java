package com.valuableauto.ValuableAutoServer.model;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDetailsImpl implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	
	private Collection<? extends GrantedAuthority> authorities;		
	private String username;
	private String password;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;

}
