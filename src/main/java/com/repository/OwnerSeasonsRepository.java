package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.OwnerSeasons;

public interface OwnerSeasonsRepository extends JpaRepository<OwnerSeasons, Long>{
	
	List<OwnerSeasons> findById(int ownerId);

}
