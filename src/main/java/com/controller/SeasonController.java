package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("seasons")
public class SeasonController {

	@Autowired
	private SeasonService seasonService;

	@GetMapping("")
	public List<Season> getSeasons() {
		return seasonService.getSeasons();
	}	

}
