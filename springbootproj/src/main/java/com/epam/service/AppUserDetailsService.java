package com.epam.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.epam.dao.UserRepository;
import com.epam.dto.UserPrincipal;
import com.epam.entity.User;

@Service
public class AppUserDetailsService implements UserDetailsService {

	private final UserRepository repository;

	public AppUserDetailsService(UserRepository repository) {
		super();
		this.repository = repository;

	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByUsername(username);
		if (null == user) {
			throw new UsernameNotFoundException("Cannot find username :" + username);
		}

		return new UserPrincipal(user);
	}

}
