package com.valuableauto.ValuableAutoServer.exception;

public class UsernameAlreadyTakenException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public UsernameAlreadyTakenException(String username) {
		super("Username " + username + " is already taken!");
	}
}
