package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private OwnerService ownerService;
	
	@GetMapping("")
	public List<Owner> getOwners() {
		return ownerService.getOwners();
	}
	
	@GetMapping("/{id}")
	public Owner getOwner(@PathVariable long id) throws Exception {
		return ownerService.getOwner(id);
	}
	
	@GetMapping("getOwnerAllTimeStats/{id}")
	public AllTimeStandingsView getOwnerAllTimeStats(@PathVariable long id) throws Exception {
		return ownerService.getOwnerAllTimeStats(id);
	}
	
	@GetMapping("getAllTimeStats")
	public List<AllTimeStandingsView> getAllTimeStats() throws Exception {
		return ownerService.getAllTimeStats();
	}
	
}
