package com.valuableauto.ValuableAutoServer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.valuableauto.ValuableAutoServer.dto.TradeDto;
import com.valuableauto.ValuableAutoServer.model.Person;
import com.valuableauto.ValuableAutoServer.model.Trade;
import com.valuableauto.ValuableAutoServer.model.Vehicle;
import com.valuableauto.ValuableAutoServer.repository.PersonRepository;
import com.valuableauto.ValuableAutoServer.repository.TradeRepository;
import com.valuableauto.ValuableAutoServer.repository.VehicleRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class TradeController {
	@Autowired
	private TradeRepository tradeRepository;
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private VehicleRepository vehicleRepository;
		
	@GetMapping(path = "/trade/{id}")
	public Trade getTrade(@PathVariable Long id) {
		return tradeRepository.findById(id).get();
	}
	
	@GetMapping(path = "/trades")
	public List<Trade> getTrades() {
		return tradeRepository.findAll();
	}
	
	@PostMapping(path = "/trade")
	public void saveTrade(@RequestBody TradeDto tradeDto) {
		Person buyer = personRepository.findById(tradeDto.getBuyerId()).get();
		Vehicle vehicle = vehicleRepository.findById(tradeDto.getVehicleId()).get();
		
		if(buyer != null && vehicle != null) {
			Trade trade = new Trade(buyer, vehicle);			
			tradeRepository.save(trade);
		}		
	}
}
