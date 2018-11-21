package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.SeasonStats;

public interface SeasonStatsRepository extends JpaRepository<SeasonStats, Long> {
	
	List<SeasonStats> findAll();
	
	SeasonStats findById(long id); 
	
	List<SeasonStats> findByOwnerId(Integer id);

	List<SeasonStats> findBySeasonId(Integer id);
	
}
