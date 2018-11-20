package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.entity.Game;
import com.repository.GameRepository;

@Service
public class GameService {
	
	private GameRepository gameRepo;

	public GameService(GameRepository gameRepo) {
		this.gameRepo = gameRepo;
	}

	public List<Game> getGames() {
		return gameRepo.findAll();
	}
	
	public List<Game> getGamesByGameType(String gameType) {
		return gameRepo.findByGameType(gameType);
	}
	
	public List<Game> getGamesByTeamId(long id) {
		return gameRepo.findByHomeTeamIdOrAwayTeamId(id, id);
	}
	
	public List<Game> getWeekGames(long seasonId, int week) {
		long season = seasonId-2010;
		return gameRepo.findBySeasonIdAndWeek(season, week);
	}
	
	public List<Game> getSeasonPlayoffGames(long seasonId) {
		String qf = "Quarter Final";
		String sf = "Semi Final";
		String sb = "Super Bowl";
		List<Game> quarters = gameRepo.findBySeasonIdAndGameType(seasonId, qf);
		List<Game> semis = gameRepo.findBySeasonIdAndGameType(seasonId, sf);
		List<Game> superBowl = gameRepo.findBySeasonIdAndGameType(seasonId, sb);
		
		List<Game> fullList = new ArrayList<Game>();
		fullList.addAll(quarters);
		fullList.addAll(semis);
		fullList.addAll(superBowl);
		
		return fullList;
	}
	
}
