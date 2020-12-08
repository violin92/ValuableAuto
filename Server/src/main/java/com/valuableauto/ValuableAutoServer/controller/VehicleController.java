package com.valuableauto.ValuableAutoServer.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.valuableauto.ValuableAutoServer.model.Person;
import com.valuableauto.ValuableAutoServer.model.Vehicle;
import com.valuableauto.ValuableAutoServer.repository.PersonRepository;
import com.valuableauto.ValuableAutoServer.repository.VehicleRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class VehicleController {
	@Autowired
	private VehicleRepository vehicleRepository;
	@Autowired
	private PersonRepository personRepository;

	@GetMapping(path = "/vehicles")
	public List<Vehicle> allVehicles() {
		return vehicleRepository.findAll();
	}

	@PostMapping(path = "/addVehicle")
	public void addVehicle(@RequestBody Vehicle vehicle) {
		if(vehicle.getSeller()!= null) {
			Person seller = personRepository.findById(vehicle.getSeller().getId()).get();
			
			if(seller != null) {
				vehicle.setSeller(seller);
				vehicleRepository.save(vehicle);
			}
		}	
	}

	@GetMapping(path = "/findVehicles", produces = "application/json")
	public List<Vehicle> findVehicleByBrandAndModel(@RequestParam String brand, @RequestParam String model) {

		return vehicleRepository.findByBrandAndModel(brand, model);
	}
}
