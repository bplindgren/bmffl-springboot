package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.AllTimeStandingsView;
import com.entity.Owner;
import com.repository.AllTimeStandingsRepository;
import com.repository.OwnerRepository;

@Service
public class OwnerService {

	@Autowired
	private OwnerRepository ownerRepo;
	@Autowired
	private AllTimeStandingsRepository atsRepo;
	
	public List<Owner> getOwners() {
		return ownerRepo.findAll();
	}
	
	public Owner getOwner(long id) {
		return ownerRepo.findById(id);
	}
	
	public AllTimeStandingsView getOwnerAllTimeStats(long id) {
		return atsRepo.findByOwnerId(id);
	}
	
	public List<AllTimeStandingsView> getAllTimeStats() {
		return atsRepo.findAll();
	}	
	
}


