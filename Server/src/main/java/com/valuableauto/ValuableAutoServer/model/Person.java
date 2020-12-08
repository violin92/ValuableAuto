package com.valuableauto.ValuableAutoServer.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Person implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(unique = true)
	private String username;
	@NotNull
	private String password;
	@NotNull
	private String name;
	@NotNull
	private Date dateOfBirth;
	@NotNull
	private String address;
	@NotNull
	private String phone;
	@NotNull
	private String mail;
	@NotNull
	private PersonType personType;
	
	private BigDecimal saldo;
	
	private PaymentMethod paymentMethod;
	
	private BigDecimal tax;
	
	private String vatNo;
}
