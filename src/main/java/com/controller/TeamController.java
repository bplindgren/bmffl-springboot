package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Record;
import com.entity.SeasonStats;
import com.entity.Team;
import com.service.TeamService;

@RestController
@CrossOrigin
@RequestMapping("teams")
public class TeamController {

	@Autowired
	private TeamService teamService;
	
	@GetMapping("")
	public List<Team> getAllTeams() {
		return teamService.getAllTeams();
	}
	
	@GetMapping("/{id}")
	public Team getTeamById(@PathVariable int id) {
		return teamService.getTeamById(id);
	}
	
	@GetMapping("/record/{id}/{week}")
	public Record getTeamRecord(@PathVariable Long id, @PathVariable Long week) {
		return teamService.getWeekRecord(id, week);
	}
	
	@GetMapping("/owner/{ownerId}")
	public List<Team> getOwnerTeams(@PathVariable int ownerId) {
		return teamService.getOwnerTeams(ownerId);
	}
	
	@GetMapping("/stats/{teamId}")
	public SeasonStats getTeamSeasonStats(@PathVariable int teamId) {
		return teamService.getTeamSeasonStats(teamId);
	}

	@GetMapping("/seasonStats")
	public List<SeasonStats> getOwnerTeamsSeasonStats() {
		return teamService.getAllTeamsSeasonStats();
	}
	
	@GetMapping("/owner/stats/{ownerId}")
	public List<SeasonStats> getOwnerTeamsSeasonStats(@PathVariable Integer ownerId) {
		return teamService.getOwnerTeamsSeasonStats(ownerId);
	}
	
	@GetMapping("/getSeasonTeams/{seasonId}")
	public List<SeasonStats> getSeasonTeams(@PathVariable Integer seasonId) {
		return teamService.getSeasonTeams(seasonId);
	}
	
}
