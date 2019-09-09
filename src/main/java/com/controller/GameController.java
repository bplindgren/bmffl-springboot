package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Game;
import com.entity.MatchupGame;
import com.entity.TeamGame;
import com.service.GameService;

@RestController
@CrossOrigin
@RequestMapping("games")
public class GameController {

	@Autowired
	private GameService gameService;

	@GetMapping("")
	public List<Game> getGames() throws Exception {
		return gameService.getGames();
	}
	
	@GetMapping("/gametype/{gameType}")
	public List<Game> getGamesByGameType(@PathVariable String gameType) throws Exception {
		return gameService.getGamesByGameType(gameType);
	}
	
	@GetMapping("/team/{teamId}")
	public List<TeamGame> getGamesByTeamID(@PathVariable long teamId) throws Exception {
		return gameService.getGamesByTeamId(teamId);
	}
	
	@GetMapping("/season/{seasonId}/week/{week}")
	public List<Game> getGamesBySeasonAndWeek(@PathVariable long seasonId, @PathVariable int week) throws Exception {
		return gameService.getWeekGames(seasonId, week);
	}
	
	@GetMapping("/season/playoffs/{seasonId}")
	public List<Game> getSeasonPlayoffGames(@PathVariable long seasonId) throws Exception {
		return gameService.getSeasonPlayoffGames(seasonId);
	}
	
	@GetMapping("/matchup/{owner1Id}/{owner2Id}")
	public List<MatchupGame> getMatchupGames(@PathVariable long owner1Id, @PathVariable long owner2Id) throws Exception {
		return gameService.getMatchupStats(owner1Id, owner2Id);
	}

}
