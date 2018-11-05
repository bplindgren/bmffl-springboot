package com.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

	List<Game> findAll();
	
	List<Game> findByGameType(String gameType);

	List<Game> findByHomeTeamIdOrAwayTeamId(int homeId, int awayId);
	
	List<Game> findBySeasonIdAndWeek(int seasonId, int week);
}
	