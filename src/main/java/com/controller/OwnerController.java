package com.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.AllTimeStandingsView;
import com.entity.Game;
import com.entity.Owner;
import com.service.OwnerService;

@RestController
@CrossOrigin
@RequestMapping("owners")
public class OwnerController {

	private OwnerService ownerService;

	public OwnerController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}
	
	@GetMapping("")
	public List<Owner> getOwners() {
		return ownerService.getOwners();
	}
	
	@GetMapping("/{name}")
	public Owner getOwner(@PathVariable String name) {
		System.out.println(name);
		String[] nameArray = name.split("-", 5);
		return ownerService.getOwner(nameArray[0], nameArray[1]);
	}
	
	@GetMapping("getAllTimeRecords")
	public List<AllTimeStandingsView> getAllTimeRecord() {
		System.out.println("getting all records");
		return ownerService.getAllTimeRecords();
	}
	
	@GetMapping("/games/{firstName}/{lastInitial}")
	public List<Game> getOwnerGames(@PathVariable String firstName, @PathVariable String lastInitial) {
		return ownerService.getOwnerGames(firstName, lastInitial);
	}
	
}
