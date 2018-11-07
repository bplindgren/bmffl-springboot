package com.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

	List<Team> findAll();
	
	List<Team> findByOwnerId(int id);
	
	Team findById(int id);
	
}
