package com.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Game;
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
	
	@GetMapping("/{id}")
	public Game getGameByID(@PathVariable int id) throws Exception {
		return gameService.getGameByID(id);
	}
	
	@GetMapping("/gametype/{gameType}")
	public List<Game> getGamesByGameType(@PathVariable String gameType) throws Exception {
		return gameService.getGamesByGameType(gameType);
	}
	
	@GetMapping("/team/{teamId}")
	public List<Game> getGamesByTeamID(@PathVariable int teamId) throws Exception {
		return gameService.getGamesByTeamId(teamId);
	}
	
	@GetMapping("/recent")
	public List<Game> getRecentGames() throws Exception {
		return gameService.getRecentGames();
	}
	
	@GetMapping("/season/{seasonId}/week/{weekId}")
	public List<Game> getGamesBySeasonAndWeek(@PathVariable String seasonId, @PathVariable String weekId) {
		return gameService.getWeekGames(seasonId, weekId);
	}

}

