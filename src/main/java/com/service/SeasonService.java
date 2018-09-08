package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.entity.Game;
import com.entity.Owner;
import com.entity.Season;
import com.entity.Team;
import com.repository.GameRepository;
import com.repository.OwnerRepository;
import com.repository.SeasonRepository;
import com.repository.TeamRepository;

@Service
public class SeasonService {

	private SeasonRepository seasonRepo;
	private GameRepository gameRepo;
	private TeamRepository teamRepo;
	private OwnerRepository ownerRepo;

	public SeasonService(SeasonRepository seasonRepo, GameRepository gameRepo, TeamRepository teamRepo, OwnerRepository ownerRepo) {
		this.seasonRepo = seasonRepo;
		this.gameRepo = gameRepo;
		this.teamRepo = teamRepo;
		this.ownerRepo = ownerRepo;
	}
	
	public List<Season> getSeasons() {
		return seasonRepo.findAll();
	}
	
	public Season getSeason(String year) {
		return seasonRepo.findByYear(year);
	}
	
	public List<Game> getSeasonGames(String year) {
		Season season = seasonRepo.findByYear(year);
		int id = season.getId();
		return gameRepo.findBySeasonId(id);
	}
	
	public List<Team> getSeasonTeams(String year) {
		Season season = seasonRepo.findByYear(year);
		int id = season.getId();
		return teamRepo.findBySeasonId(id);
	}
	
	public List<Owner> getSeasonOwners(String year) {
		List<Team> seasonTeams = getSeasonTeams(year);
		List<Integer> teamIDs = new ArrayList<Integer>();
		
		for(Team t: seasonTeams) {
				teamIDs.add(t.getId());
			}
		
		System.out.println(teamIDs);	
		
		List<Owner> seasonOwners = new ArrayList<Owner>();
		seasonOwners = ownerRepo.findById(teamIDs);
		return seasonOwners;
	}
	
}
