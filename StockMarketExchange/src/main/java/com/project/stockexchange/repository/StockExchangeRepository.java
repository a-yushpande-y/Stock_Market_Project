package com.project.stockexchange.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.stockexchange.models.StockExchange;



public interface StockExchangeRepository extends CrudRepository<StockExchange, Integer> {

}
