package com.idat.pe.ec1.OscarMunoz.app.Security;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		if("oscar".equals(username)) {
			return new User("oscar", "123", new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("El usuario " + username + " no existe!");
		}
		
	}

}
