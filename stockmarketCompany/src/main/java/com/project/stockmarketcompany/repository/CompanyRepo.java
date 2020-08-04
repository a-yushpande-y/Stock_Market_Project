package com.project.stockmarketcompany.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.stockmarketcompany.models.Company;


@Repository
public interface CompanyRepo extends CrudRepository<Company,Integer>{

	@Query("SELECT c FROM Company c WHERE name like %?1%")
	List<Company> findCompanyByMatchingName(String name);
	
	
}
