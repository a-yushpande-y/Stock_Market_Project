package com.project.stockexchange.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.stockexchange.models.StockExchange;
import com.project.stockexchange.repository.StockExchangeRepository;

@Service
public class StockExchangeService {

	@Autowired
	private StockExchangeRepository stockexchangeRepository;
	
	public Iterable<StockExchange> findAll(){
		return stockexchangeRepository.findAll();
	}
	
	public void save(StockExchange stockexchange) {
	stockexchangeRepository.save(stockexchange);
	}
	public void delete(Integer id) {
	Optional<StockExchange> stockexchange = stockexchangeRepository.findById(id);
	stockexchangeRepository.delete(stockexchange.get());
	}
	
	public StockExchange findById(int id) {
		Optional<StockExchange> stockexchange = stockexchangeRepository.findById(id);
		return stockexchange.get();
	}
	}
