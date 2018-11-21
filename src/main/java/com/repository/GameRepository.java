package com.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

	List<Game> findAll();
	
	List<Game> findByGameType(String gameType);

	List<Game> findByHomeTeamIdOrAwayTeamId(long homeId, long awayId);
	
	List<Game> findBySeasonIdAndWeek(long seasonId, int week);
	
	List<Game> findBySeasonIdAndGameType(long seasonId, String gameType);
	
	List<Game> findByIdIn(List<Long> gameIdList);
	
}
	