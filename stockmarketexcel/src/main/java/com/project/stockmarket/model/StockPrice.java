package com.project.stockmarket.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StockPrice")
public class StockPrice {
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  @Column(name = "id")
	  private Integer id;

	  @Column(name = "companyCode")
	  private Integer companyCode;

	  @Column(name = "stockExchange")
	  private String stockExchange;

	  @Column(name = "price")
	  private Double price;
	  
	  @Column(name = "date")
	  private Date date;
	  
	  @Column(name = "time")
	  private Time time;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(Integer companyCode) {
		this.companyCode = companyCode;
	}

	public String getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
	  
}
