package com.valuableauto.ValuableAutoServer.model;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Vehicle implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =  GenerationType.SEQUENCE)
	private Long id;
	@NotNull
	private String brand;
	@NotNull
	private String model;
	@NotNull
	private String engine;
	@NotNull
	private Integer hp;
	@NotNull
	private Date dateOfRegistration;
	@NotNull
	private String color;
	@NotNull
	private BigDecimal price;
	@NotNull
	private boolean approved;
	@NotNull
	@OneToOne(cascade = CascadeType.REMOVE)
	private Person seller;
}
