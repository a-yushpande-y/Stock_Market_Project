package com.project.stockmarket.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.stockmarket.dto.StockPriceRequestDto;
import com.project.stockmarket.dto.StockPriceResponseDto;
import com.project.stockmarket.helper.ExcelHelper;
import com.project.stockmarket.model.DateStock;
import com.project.stockmarket.model.Stock;
import com.project.stockmarket.model.StockPrice;
import com.project.stockmarket.repository.StockPriceRepository;
import com.project.stockmarket.helper.Converter;


@Service
public class StockPriceService {

	@Autowired
	  StockPriceRepository repository;

	  public StockPriceResponseDto save(MultipartFile file) throws ParseException {
	    try {
	    	
	    StockPriceResponseDto rdto =new StockPriceResponseDto();
	      List<StockPriceRequestDto> dtos = ExcelHelper.excelToStock(file.getInputStream());
	      rdto.setCompanyCode(dtos.get(0).getCompanyCode());
	      rdto.setStockExchange(dtos.get(0).getStockExchange());
	      rdto.setFromDate(dtos.get(0).getDate());
	      rdto.setToDate(dtos.get(dtos.size()-1).getDate());
	      rdto.setNoOfRecords(dtos.size());
	      
	      List<StockPrice> stockPrices = Converter.convertDtoListToStock(dtos);
	      repository.saveAll(stockPrices);
	      return rdto;
	    } catch (IOException e) {
	      throw new RuntimeException("fail to store excel data: " + e.getMessage());
	    }
	  }
	  public List<DateStock> getPrices(Stock stock){
		  if(stock.getPeriod().equals("daily"))
			  return repository.getPriceByIdDaily(stock.getId(),stock.getFrom(), stock.getTo());
		  else if(stock.getPeriod().equals("weekly"))
				  return repository.getPriceByIdWeekly(stock.getId(),stock.getFrom(), stock.getTo());
		 else
			  return repository.getPriceByIdMonthly(stock.getId(),stock.getFrom(), stock.getTo());
	  }
}
