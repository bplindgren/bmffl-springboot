package com.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

	List<Team> findAll();
	
	List<Team> findByOwnerId(long id);
	
	Team findById(long id);
	
}
