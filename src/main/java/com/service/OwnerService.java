package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.entity.Game;
import com.entity.Owner;
import com.entity.Team;
import com.repository.OwnerRepository;

@Service
public class OwnerService {

	private OwnerRepository ownerRepo;

	public OwnerService(OwnerRepository ownerRepo) {
		this.ownerRepo = ownerRepo;
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
		Set<Team> teams = owner.getTeams();
		
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
	
}


