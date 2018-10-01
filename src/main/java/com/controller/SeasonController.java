package com.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Game;
import com.entity.Owner;
import com.entity.OwnerSeasons;
import com.entity.Season;
import com.entity.Team;
import com.service.SeasonService;

@RestController
@CrossOrigin
@RequestMapping("season")
public class SeasonController {

	private SeasonService seasonService;

	public SeasonController(SeasonService seasonService) {
		this.seasonService = seasonService;
	}

	@GetMapping("")
	public List<Season> getSeasons() {
		return seasonService.getSeasons();
	}	
	
	@GetMapping("/getOwnerSeasons/{owner_id}")
	public OwnerSeasons getOwnerSeasons(@PathVariable String owner_id) {
		return seasonService.getOwnerSeasons(owner_id);
	}

	@GetMapping("/{year}")
	public Season getSeason(@PathVariable String year) {
		return seasonService.getSeason(year);
	}
	
	@GetMapping("/{year}/games")
	public List<Game> getSeasonGames(@PathVariable String year) {
		return seasonService.getSeasonGames(year);
	}
	
	@GetMapping("/{year}/teams")
	public List<Team> getSeasonTeams(@PathVariable String year) {
		return seasonService.getSeasonTeams(year);
	}
	
	@GetMapping("/{year}/owners")
	public List<Owner> getSeasonOwners(@PathVariable String year) {
		return seasonService.getSeasonOwners(year);
	}

}
