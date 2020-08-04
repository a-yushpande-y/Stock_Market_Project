package com.project.stockmarketcompany.repository;

import org.springframework.data.repository.CrudRepository;

import com.project.stockmarketcompany.models.IPODetails;

public interface IPORepo extends CrudRepository<IPODetails,Integer>{


	IPODetails findByCompanyId(Integer id);
}
