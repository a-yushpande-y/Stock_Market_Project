package com.project.stockmarketsector.models;


import javax.persistence.Entity;

import javax.persistence.Id;


import javax.persistence.Table;

@Entity
@Table(name = "sectors")
public class Sector {

	@Id
	private Integer id;
	private String name;
	private String brief;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}

	
}