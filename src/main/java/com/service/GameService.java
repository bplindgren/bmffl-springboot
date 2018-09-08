package com.service;

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
	
	public Game getGameByID(int id) {
		return gameRepo.findById(id);
	}
	
	public List<Game> getGamesByGameType(String gameType) {
		return gameRepo.findByGameType(gameType);
	}
	
	public List<Game> getGamesByTeamId(int id) {
		List<Game> games = gameRepo.findByHomeTeamIdOrAwayTeamId(id, id);
		System.out.println(games.size());
		return games;
	}
	
	public List<Game> getRecentGames() {
		return gameRepo.findTop5ByOrderByIdDesc();
	}
	
	public List<Game> getWeekGames(String seasonId, String weekId) {
		int season = Integer.parseInt(seasonId)-2010;
		int week = Integer.parseInt(weekId);
		return gameRepo.findBySeasonIdAndWeek(season, week);
	}
	
}
