package com.valuableauto.ValuableAutoServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valuableauto.ValuableAutoServer.model.Trade;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long>{

}
