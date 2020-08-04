package com.project.stockmarketsector.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.stockmarketsector.models.Sector;
import com.project.stockmarketsector.service.SectorService;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/sectors")
public class SectorController {
	
	@Autowired
	
	SectorService sectorService;
	
	@RequestMapping("/getAllSectors")
	public Iterable<Sector> getAllSectors(){
		return sectorService.getAllSectors();
	}
	
	@PostMapping("/saveSector")
	public  Sector saveCompany(@RequestBody Sector sector) {
		sectorService.save(sector);
		return sector;
	}
	
	@PutMapping("/updateSector/{sectorid}")
	public Sector updateSector(@RequestBody Sector sector,@PathVariable("sectorid") Integer sectorid) {
		sector.setId(sectorid);
		
		sectorService.save(sector);
		return sector;
	}
	@DeleteMapping("/deleteSector/{sectorid}")
	public Boolean deleteCompany(@PathVariable("sectorid") Integer sectorId) {
		sectorService.delete(sectorId);
		return true;
	}
	@GetMapping("/findOneInAll3/{sectorid}")
	public Sector findoneinall(@PathVariable("sectorid") Integer sectorid) {
		return sectorService.findById(sectorid);
	
	}
}

