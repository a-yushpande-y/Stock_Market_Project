package com.project.stockmarketcompany.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.stockmarketcompany.feign.StockServiceClient;
import com.project.stockmarketcompany.models.Company;
import com.project.stockmarketcompany.models.DateStock;
import com.project.stockmarketcompany.models.Stock;
import com.project.stockmarketcompany.repository.CompanyRepo;

@Service
public class CompanyService {

	CompanyRepo repo;
	StockServiceClient client;
	
	public List<String> findMatching(String name){
		
		List<Company> companies = repo.findCompanyByMatchingName(name);
		List<String> names = new ArrayList<String>();
		for (Company c:companies) {
			names.add(c.getName());
		}
		return names;
	}
	
	public Company findInfo(Integer id){
		return repo.findById(id).get();
	}
	
	public ResponseEntity<List<DateStock>> findPrice(Stock stock){
		
		return client.getCompanyStockPrice(stock);
	}
	
	
}
