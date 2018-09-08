package com.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Season;

public interface SeasonRepository extends JpaRepository<Season, Long> {

	List<Season> findAll();
	
	Season findByYear(String year);
}
