package com.valuableauto.ValuableAutoServer.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.valuableauto.ValuableAutoServer.dto.PersonDto;
import com.valuableauto.ValuableAutoServer.exception.UserAuthenticationFailedException;
import com.valuableauto.ValuableAutoServer.exception.UsernameAlreadyTakenException;
import com.valuableauto.ValuableAutoServer.model.Person;
import com.valuableauto.ValuableAutoServer.repository.PersonRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class PersonController {
	@Autowired
	private PersonRepository repository;

	@Autowired
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@PostMapping(path = "/signUp", consumes = "application/json")
	public void signUp(@RequestBody Person person) throws UsernameAlreadyTakenException{
		if(person != null) {
			if(repository.findByUsername(person.getUsername()) != null)
				throw new UsernameAlreadyTakenException(person.getUsername());
			
			person.setPassword(encoder.encode(person.getPassword()));
			repository.save(person);
		}
	}

	@PostMapping(path = "/auth", consumes = "application/json")
	public ResponseEntity<Person> personAuth(@RequestBody PersonDto personDto) throws UserAuthenticationFailedException{
		ResponseEntity<Person> response;
		Person person = repository.findByUsername(personDto.getUsername());

		if (person != null) {
			if (encoder.matches(personDto.getPassword(), person.getPassword())) {
				response = ResponseEntity.ok().body(person);
				return response;
			} else 
				throw new UserAuthenticationFailedException();
		}

		response = ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		return response;
	}

	@GetMapping(path = "/user/{username}")
	public Person getUserByUsername(@PathVariable String username) {
		return repository.findByUsername(username);
	}
}
