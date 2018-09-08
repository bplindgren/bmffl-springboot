package com.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Record;
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
	
	@GetMapping("/{id}")
	public Team getTeamById(@PathVariable int id) {
		return teamService.getTeamById(id);
	}
	
	@GetMapping("/record/{id}/{week}")
	public Record getTeamRecord(@PathVariable String id, @PathVariable String week) {
		return teamService.getWeekRecord(id, week);
	}
	
}
