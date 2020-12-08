package com.valuableauto.ValuableAutoServer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {
	
	@ResponseBody
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(UserAuthenticationFailedException.class)
	public String authenticationFailed(UserAuthenticationFailedException ex) {
		return ex.getMessage();
	}
	
	@ResponseBody
	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler(UsernameAlreadyTakenException.class)
	public String usernameAlreadyTaken(UsernameAlreadyTakenException ex) {
		return ex.getMessage();
	}
}
