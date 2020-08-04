package com.project.stockmarketcompany.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.stockmarketcompany.models.DateStock;
import com.project.stockmarketcompany.models.Stock;

@FeignClient(name = "excel")
public interface StockServiceClient {
	
	 @PostMapping("/cstockp")
	 public ResponseEntity<List<DateStock>> getCompanyStockPrice(@RequestBody Stock stock);
	 
}
