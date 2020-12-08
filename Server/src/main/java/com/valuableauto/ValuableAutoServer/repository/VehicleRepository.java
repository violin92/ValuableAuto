package com.valuableauto.ValuableAutoServer.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valuableauto.ValuableAutoServer.model.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long>{
	
	public List<Vehicle> findByBrandAndModel(String brand, String model);

}
