package com.project.stockmarketcompany.models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "IPODetails")
public class IPODetails {
	
	@Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  @Column(name = "id")
	  private Integer id;

	  @Column(name = "companyId")
	  private Integer companyId;

	  @Column(name = "companyName")
	  private String companyName;

	  @Column(name = "stockExchange")
	  private String stockExchange;
	  
	  @Column(name = "pps")
	  private Double pps;
	  
	  @Column(name = "totalnum")
	  private Integer totalnum;
	
	  @Column(name = "openDateTime")
	  private Timestamp openDateTime;
	  
	  @Column(name = "remarks")
	  private String remarks;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}

	public Double getPps() {
		return pps;
	}

	public void setPps(Double pps) {
		this.pps = pps;
	}

	public Integer getTotalnum() {
		return totalnum;
	}

	public void setTotalnum(Integer totalnum) {
		this.totalnum = totalnum;
	}

	public Timestamp getOpenDateTime() {
		return openDateTime;
	}

	public void setOpenDateTime(Timestamp openDateTime) {
		this.openDateTime = openDateTime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
