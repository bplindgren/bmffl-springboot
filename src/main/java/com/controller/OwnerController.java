package com.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.AllTimeStandingsView;
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
	
	@GetMapping("/{id}")
	public Owner getOwner(@PathVariable long id) {
		return ownerService.getOwner(id);
	}
	
	@GetMapping("getOwnerAllTimeStats/{id}")
	public AllTimeStandingsView getOwnerAllTimeStats(@PathVariable long id) {
		return ownerService.getOwnerAllTimeStats(id);
	}
	
	@GetMapping("getAllTimeStats")
	public List<AllTimeStandingsView> getAllTimeStats() {
		return ownerService.getAllTimeStats();
	}
	
}
