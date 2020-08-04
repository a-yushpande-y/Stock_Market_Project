package com.project.stockmarket.model;

import java.sql.Date;

public class DateStock {

	private Double price;
	private Date date;
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
}
