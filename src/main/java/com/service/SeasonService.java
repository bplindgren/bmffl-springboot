package com.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Service;

import com.entity.Game;
import com.entity.Owner;
import com.entity.OwnerSeasons;
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
	@PersistenceContext
	private EntityManager em;

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
	
//	public List<OwnerSeasons> getOwnerSeasons() {
	public String getOwnerSeasons(String owner_id) {
		Integer owner_int = Integer.parseInt(owner_id);
		System.out.println(owner_int);
		StoredProcedureQuery query = em.createStoredProcedureQuery("get_owner_seasons");
		query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN);
		query.setParameter(1, owner_int);	
		
		String result = (String) query.getSingleResult();
		return result;
	}
	
}
