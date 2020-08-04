package com.project.stockmarketcompany.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Company")
public class Company {
		  @Id
		  @GeneratedValue(strategy = GenerationType.AUTO)
		  @Column(name = "id")
		  private Integer id;

		  @Column(name = "name")
		  private String name;

		  @Column(name = "turnover")
		  private Double turnover;

		  @Column(name = "ceo")
		  private String ceo;
		  
		  @Column(name = "directors")
		  private String directors;
		  
		  @Column(name = "sector")
		  private String sector;
		  
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

		public Double getTurnover() {
			return turnover;
		}

		public void setTurnover(Double turnover) {
			this.turnover = turnover;
		}

		public String getCeo() {
			return ceo;
		}

		public void setCeo(String ceo) {
			this.ceo = ceo;
		}

		public String getDirectors() {
			return directors;
		}

		public void setDirectors(String directors) {
			this.directors = directors;
		}

		public String getSector() {
			return sector;
		}

		public void setSector(String sector) {
			this.sector = sector;
		}

		public String getBrief() {
			return brief;
		}

		public void setBrief(String brief) {
			this.brief = brief;
		}

		@Column(name = "brief")
		  private String brief;
}
