package com.project.stockmarketcompany.service;

import org.springframework.stereotype.Service;

import com.project.stockmarketcompany.models.Company;
import com.project.stockmarketcompany.models.IPODetails;
import com.project.stockmarketcompany.repository.IPORepo;

@Service
public class IPOService {

	IPORepo repo;
	public IPODetails findInfo(Integer id){
		return repo.findByCompanyId(id);
	}
}
