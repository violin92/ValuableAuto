package com.valuableauto.ValuableAutoServer.exception;

public class UserAuthenticationFailedException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public UserAuthenticationFailedException() {
		super("The entered username and/or password is invalid!");
	}

}
