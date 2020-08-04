package com.project.stockmarket.helper;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.project.stockmarket.dto.StockPriceRequestDto;
import com.project.stockmarket.model.StockPrice;
import java.util.logging.Level; 
import java.util.logging.Logger;
public class Converter {

	private final static Logger LOGGER =  
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	public static List<StockPrice> convertDtoListToStock(List<StockPriceRequestDto> dto){
		
		List<StockPrice> toReturn =new ArrayList<StockPrice>();
		
		for(StockPriceRequestDto s:dto) {
			LOGGER.log(Level.INFO,s.getStockExchange());
			LOGGER.log(Level.INFO,s.getDate());
			StockPrice temp = new StockPrice();
			temp.setCompanyCode(s.getCompanyCode());
			temp.setStockExchange(s.getStockExchange());
			temp.setPrice(s.getPrice());
			temp.setDate(Date.valueOf(s.getDate()));
			temp.setTime(Time.valueOf(s.getTime()));
			toReturn.add(temp);
			//LOGGER.log(Level.INFO,"One done");
		}
		return toReturn;
	}
}
