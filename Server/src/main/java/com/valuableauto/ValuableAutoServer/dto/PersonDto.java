package com.valuableauto.ValuableAutoServer.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class PersonDto {
	
	private final String username;
	private final String password;

}
