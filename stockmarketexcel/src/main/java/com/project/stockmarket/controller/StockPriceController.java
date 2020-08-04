package com.project.stockmarket.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.stockmarket.dto.StockPriceResponseDto;
import com.project.stockmarket.helper.ExcelHelper;
import com.project.stockmarket.message.ResponseMessage;
import com.project.stockmarket.model.DateStock;
import com.project.stockmarket.model.Stock;
import com.project.stockmarket.service.StockPriceService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class StockPriceController {
	@Autowired
	  StockPriceService fileService;

	  @PostMapping("/import")
	  public ResponseEntity<StockPriceResponseDto> uploadFile(@RequestParam("file") MultipartFile file) throws ParseException {

	    if (ExcelHelper.hasExcelFormat(file)) {
	        StockPriceResponseDto response = fileService.save(file);  
	        return ResponseEntity.status(HttpStatus.OK).body(response);
	    }
	   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StockPriceResponseDto());
	  }
	  
	@PostMapping("/cstockp")
	public ResponseEntity<List<DateStock>> getCompanyStockPrice(@RequestBody Stock stock){
		List<DateStock> list= fileService.getPrices(stock);
		return ResponseEntity.status(HttpStatus.OK).body(list);
		
	}


}
