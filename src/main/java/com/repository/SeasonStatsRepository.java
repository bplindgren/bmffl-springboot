package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.SeasonStats;

public interface SeasonStatsRepository extends JpaRepository<SeasonStats, Long> {
	
	List<SeasonStats> findByOwnerId(int id);
	
}
