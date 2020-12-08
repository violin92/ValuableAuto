package com.valuableauto.ValuableAutoServer;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.valuableauto.ValuableAutoServer.model.Person;
import com.valuableauto.ValuableAutoServer.model.UserDetailsImpl;
import com.valuableauto.ValuableAutoServer.repository.PersonRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private PersonRepository personRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Person person = personRepository.findByUsername(username);
		
		if (person != null)
			return new UserDetailsImpl(null, username, person.getPassword(), true, true, true, true);
		else
			throw new UsernameNotFoundException("Username " + username + "was not found!");
	}
}
