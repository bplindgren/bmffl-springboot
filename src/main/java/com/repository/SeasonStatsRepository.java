package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.SeasonStats;
import com.entity.Team;

public interface SeasonStatsRepository extends JpaRepository<SeasonStats, Long> {
	
	List<SeasonStats> findAll();
	
	List<SeasonStats> findByOwnerId(int id);

	List<SeasonStats> findBySeasonId(int id);
}
