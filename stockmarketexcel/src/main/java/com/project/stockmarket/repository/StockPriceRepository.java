package com.project.stockmarket.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.stockmarket.model.DateStock;
import com.project.stockmarket.model.StockPrice;

@Repository
public interface StockPriceRepository extends CrudRepository<StockPrice,Integer>{

	@Query(value = "select price from stock_price where company_code = ?1 AND date between(?1,?2) group by date",nativeQuery=true)
	public List<DateStock> getPriceByIdDaily(Integer id, Date from, Date to);
	
	@Query(value = "select price from stock_price where company_code = ?1 AND date between(?1,?2) group by WEEK(date)",nativeQuery=true)
	public List<DateStock> getPriceByIdWeekly(Integer id, Date from, Date to);
	
	@Query(value = "select price from stock_price where company_code = ?1 AND date between(?1,?2) group by MONTH(date)",nativeQuery=true)
	public List<DateStock> getPriceByIdMonthly(Integer id, Date from, Date to);
}
