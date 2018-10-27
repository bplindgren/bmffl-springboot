package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.assertj.core.util.Arrays;
import org.postgresql.core.Query;
import org.springframework.stereotype.Service;

import com.entity.AllTimeStandingsView;
import com.entity.Game;
import com.entity.Owner;
import com.entity.Record;
import com.entity.Team;
import com.repository.AllTimeStandingsRepository;
import com.repository.OwnerRepository;

@Service
public class OwnerService {

	private OwnerRepository ownerRepo;
	private AllTimeStandingsRepository atsRepo;
	@PersistenceContext
	private EntityManager em;

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
	
	public List<Owner> getDivisionOwners(String division) {
		return ownerRepo.findByDivision(division);
	}
	
	public AllTimeStandingsView getOwnerAllTimeStats(Integer id) {
		AllTimeStandingsView res = atsRepo.findByOwnerId(id);
		return res;
	}
	
	public List<AllTimeStandingsView> getAllTimeRecords() {		
//		List<Record> records = em.createQuery("SELECT wins, losses, ties FROM bmffl.vw_all_time_standings", Record.class).getResultList();

		List<AllTimeStandingsView> res = atsRepo.findAll();
		return res;
	}	
	
}


