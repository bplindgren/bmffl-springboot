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
	
	public Owner getOwner(String firstName, String lastInitial) {
		return ownerRepo.findByFirstNameAndLastInitial(firstName, lastInitial);
	}
	
	public List<Owner> getDivisionOwners(String division) {
		return ownerRepo.findByDivision(division);
	}
	
	public List<Game> getOwnerGames(String firstName, String lastInitial) {
		// Get the owner and its teams
		Owner owner = this.getOwner(firstName, lastInitial);
		List<Team> teams = owner.getTeams();
		
		// Create an empty List of games 	
		List<Game> ownerGames = new ArrayList<>();
		
		// Add each team's home and away games
		for (Team team : teams) {
			List<Game> teamHomeGames = team.getHomeGames();
			ownerGames.addAll(teamHomeGames);
			List<Game> teamAwayGames = team.getAwayGames();
			ownerGames.addAll(teamAwayGames);
		}
		
		return ownerGames;
	}
	
	public List<AllTimeStandingsView> getAllTimeRecords() {		
//		StoredProcedureQuery query = em.createStoredProcedureQuery("get_all_time_records");
//		
//		String result = (String) query.getSingleResult();
//		String[] values = result.split("-");
//		int wins = Integer.parseInt(values[0]);
//		int losses = Integer.parseInt(values[1]);
//		int ties = Integer.parseInt(values[2]);
//		
//		Record record = new Record(wins, losses, ties);
//		List<Record> records = em.createQuery("SELECT wins, losses, ties FROM bmffl.vw_all_time_standings", Record.class).getResultList();
//		System.out.println(records.toString());
		//		return records;

		List<AllTimeStandingsView> res = atsRepo.findAll();
		System.out.println("1");
		System.out.println(res.toString());
		System.out.println("2");
		return res;
	}	
	
}


