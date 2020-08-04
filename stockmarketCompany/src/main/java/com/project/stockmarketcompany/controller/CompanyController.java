package com.project.stockmarketcompany.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.stockmarketcompany.models.Company;
import com.project.stockmarketcompany.models.DateStock;
import com.project.stockmarketcompany.models.IPODetails;
import com.project.stockmarketcompany.models.Stock;
import com.project.stockmarketcompany.service.CompanyService;
import com.project.stockmarketcompany.service.IPOService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class CompanyController {
	
	CompanyService cservice;
	IPOService iposervice;
	/*getCompanyStockPrice i/p Company ID, From Period, To Period, periodicity
	getMatchingCompanies – used to retrieve list of Companies based on pattern matching of Company Name 
	getCompanyDetails – Basic information about company
	getCompanyIPODetails – IPODetails of Company */
	
	
	@PostMapping("/getstockprice")
	public ResponseEntity<List<DateStock>> getCompanyStockPrice(@RequestBody Stock stock){
		return cservice.findPrice(stock);
		
	}
	@GetMapping("/getmatching/{name}")
	public ResponseEntity<List<String>> getMatchingCompanies(@PathVariable String name){
		return ResponseEntity.status(HttpStatus.OK).body(cservice.findMatching(name));
	}
	
	@GetMapping("/getinfo/{id}")
	public ResponseEntity<Company> getCompanyDetails(@PathVariable Integer id){
		return ResponseEntity.status(HttpStatus.OK).body(cservice.findInfo(id));
	}
	
	@GetMapping("/getipoinfo/{id}")
	public ResponseEntity<IPODetails> getIPODetails(@PathVariable Integer id){
		return ResponseEntity.status(HttpStatus.OK).body(iposervice.findInfo(id));
	}
	
}
