package com.valuableauto.ValuableAutoServer.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Trade implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@CreationTimestamp
	private Date date;
	@NotNull
	@OneToOne(cascade = CascadeType.REMOVE)
	private Person buyer;
	@NotNull
	@OneToOne(cascade = CascadeType.REMOVE)
	private Vehicle vehicle;
	
	public Trade(Person buyer, Vehicle vehicle) {
		super();
		this.buyer = buyer;
		this.vehicle = vehicle;
	}
	
	
}
