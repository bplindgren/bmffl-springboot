package com.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

	List<Game> findAll();
	
	Game findById(int id);
	
	List<Game> findByGameType(String gameType);
	
	List<Game> findBySeasonId(int id);

	List<Game> findByHomeTeamIdOrAwayTeamId(int homeId, int awayId);
	
	List<Game> findTop5ByOrderByIdDesc();
	
	List<Game> findBySeasonIdAndWeek(int seasonId, int week);
}
	