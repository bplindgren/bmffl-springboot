package com.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.entity.AllTimeStandingsView;
import com.entity.Owner;
import com.repository.AllTimeStandingsRepository;
import com.repository.OwnerRepository;

@Service
public class OwnerService {

	private OwnerRepository ownerRepo;
	private AllTimeStandingsRepository atsRepo;

	public OwnerService(OwnerRepository ownerRepo, AllTimeStandingsRepository atsRepo) {
		this.ownerRepo = ownerRepo;
		this.atsRepo = atsRepo;
	}
	
	public List<Owner> getOwners() {
		return ownerRepo.findAll();
	}
	
	public Owner getOwner(Integer id) {
		return ownerRepo.findById(id);
	}
	
	public AllTimeStandingsView getOwnerAllTimeStats(Integer id) {
		return atsRepo.findByOwnerId(id);
	}
	
	public List<AllTimeStandingsView> getAllTimeRecords() {
		return atsRepo.findAll();
	}	
	
}


