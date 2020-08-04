package com.project.stockmarketcompany.models;

import java.sql.Date;

public class Stock {

		private Integer id;
		private Date from;
		private Date to;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Date getFrom() {
			return from;
		}
		public void setFrom(Date from) {
			this.from = from;
		}
		public Date getTo() {
			return to;
		}
		public void setTo(Date to) {
			this.to = to;
		}
		public String getPeriod() {
			return period;
		}
		public void setPeriod(String period) {
			this.period = period;
		}
		private String period;
	}
