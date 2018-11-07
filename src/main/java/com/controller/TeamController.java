package com.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Record;
import com.entity.Season;
import com.entity.SeasonStats;
import com.entity.Team;
import com.service.TeamService;

@RestController
@CrossOrigin
@RequestMapping("teams")
public class TeamController {

	private TeamService teamService;

	public TeamController(TeamService teamService) {
		this.teamService = teamService;
	}
	
	@GetMapping("")
	public List<Team> getAllTeams() {
		return teamService.getAllTeams();
	}
	
	@GetMapping("/{id}")
	public Team getTeamById(@PathVariable int id) {
		return teamService.getTeamById(id);
	}
	
	@GetMapping("/record/{id}/{week}")
	public Record getTeamRecord(@PathVariable String id, @PathVariable String week) {
		return teamService.getWeekRecord(id, week);
	}
	
	@GetMapping("/owner/{owner_id}")
	public List<Team> getOwnerTeams(@PathVariable int owner_id) {
		return teamService.getOwnerTeams(owner_id);
	}
	
	@GetMapping("/owner/stats/{owner_id}")
	public List<SeasonStats> getOwnerTeamsSeasonStats(@PathVariable int owner_id) {
		return teamService.getOwnerTeamsSeasonStats(owner_id);
	}
	
	@GetMapping("/getSeasonTeams/{season_id}")
	public List<SeasonStats> getSeasonTeams(@PathVariable int season_id) {
		return teamService.getSeasonTeams(season_id);
	}
	
}
