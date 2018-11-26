package com.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Game;
import com.entity.MatchupStats;
import com.service.GameService;

@RestController
@CrossOrigin
@RequestMapping("games")
public class GameController {

	private GameService gameService;
	
	public GameController(GameService gameService) {
		this.gameService = gameService;
	}

	@GetMapping("")
	public List<Game> getGames() {
		return gameService.getGames();
	}
	
	@GetMapping("/gametype/{gameType}")
	public List<Game> getGamesByGameType(@PathVariable String gameType) throws Exception {
		return gameService.getGamesByGameType(gameType);
	}
	
	@GetMapping("/team/{teamId}")
	public List<Game> getGamesByTeamID(@PathVariable long teamId) throws Exception {
		return gameService.getGamesByTeamId(teamId);
	}
	
	@GetMapping("/season/{seasonId}/week/{week}")
	public List<Game> getGamesBySeasonAndWeek(@PathVariable long seasonId, @PathVariable int week) {
		return gameService.getWeekGames(seasonId, week);
	}
	
	@GetMapping("/season/playoffs/{seasonId}")
	public List<Game> getSeasonPlayoffGames(@PathVariable long seasonId) {
		return gameService.getSeasonPlayoffGames(seasonId);
	}
	
	@GetMapping("/matchup/{owner1Id}/{owner2Id}")
	public MatchupStats getMatchupStats(@PathVariable long owner1Id, @PathVariable long owner2Id) {
		return gameService.getMatchupStats(owner1Id, owner2Id);
	}

}
