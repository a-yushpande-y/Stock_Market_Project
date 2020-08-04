package com.project.stockmarketsector.repository;
import org.springframework.data.repository.CrudRepository;

import com.project.stockmarketsector.models.Sector;



public interface SectorRepository extends CrudRepository<Sector,Integer> {
	
	Iterable<Sector> findAll();

}