package com.project.stockmarketsector.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.stockmarketsector.models.Sector;
import com.project.stockmarketsector.repository.SectorRepository;

@Service
public class SectorService {

	private SectorRepository sectorRepository;
	
	public Iterable<Sector> getAllSectors(){
		return sectorRepository.findAll();
	}
	
	public Sector save(Sector sector) {
	sectorRepository.save(sector);
	return sector;
	}
	
	public boolean delete(int sectorId) {
	Optional<Sector> sector = sectorRepository.findById(sectorId);
	sectorRepository.delete(sector.get());
	return true;
	}
	
	public Sector findById(int sectorId) {
	return sectorRepository.findById(sectorId).get();
	}
	
	
}
