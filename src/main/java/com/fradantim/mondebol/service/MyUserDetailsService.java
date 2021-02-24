package com.fradantim.mondebol.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService  implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return searchUserInBD(username);
	}

	/** Searches the user in the database by the username. Totally not hardcoded */
	private UserDetails searchUserInBD(String username) {
		return new UserDetails() {
			public boolean isEnabled() { return true; } 
			
			public boolean isCredentialsNonExpired() { return true; }
			
			public boolean isAccountNonLocked() { return true; }
			
			public boolean isAccountNonExpired() { return true; }
			
			public String getUsername() { return username; }
			
			public String getPassword() { return pwdEnconder.encode(username); }
			
			public Collection<? extends GrantedAuthority> getAuthorities() { 
				return Arrays.asList(
						new GrantedAuthority() {
							private static final long serialVersionUID = 1L; 
							public String getAuthority() { return "ROL_ESPECIFICO_1";}
							public String toString() { return getAuthority(); }
							},
						new GrantedAuthority() {
							private static final long serialVersionUID = 1L; 
							public String getAuthority() { return "ROL_ESPECIFICO_2";}
							public String toString() { return getAuthority(); }
							}
						);
				}
			
			private static final long serialVersionUID = 1L;
		};				
	}
	
	@Autowired
	private PasswordEncoder pwdEnconder;
}