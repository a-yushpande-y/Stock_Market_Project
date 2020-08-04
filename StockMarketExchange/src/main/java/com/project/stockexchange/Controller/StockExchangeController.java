package com.project.stockexchange.Controller;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.stockexchange.models.StockExchange;
import com.project.stockexchange.repository.StockExchangeRepository;
import com.project.stockexchange.service.StockExchangeService;



@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/StockExchange")
public class StockExchangeController {
	
	@Autowired
	private StockExchangeService stockexchangeService;

	@RequestMapping("/getAllStockExchange")
	public Iterable<StockExchange> getAllStockExchange(){
		return stockexchangeService.findAll();
	}
	
	@PostMapping("/saveStockExchange")
	public  StockExchange saveStockExchange(@RequestBody StockExchange stockexchange) {
		stockexchangeService.save(stockexchange);
		return stockexchange;
	}
	
	@PutMapping("/updateStockExchange/{seid}")
	public StockExchange updateStockExchange(@RequestBody StockExchange stockexchange,@PathVariable("seid") Integer seid) {
		stockexchange.setStockid(seid);
		System.out.println(stockexchange);
		
		stockexchangeService.save(stockexchange);
		return stockexchange;
	}
	@DeleteMapping("/deleteStockExchange/{seid}")
	public Boolean deleteStockExchange(@PathVariable("seid") Integer seid) {
		stockexchangeService.delete(seid);
		return true;
	}
	@GetMapping("/findOneInAll4/{seid}")
	public StockExchange findoneinall(@PathVariable("seid") Integer seid) {
		return stockexchangeService.findById(seid);
	
	}
}
