package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

	List<Owner> findAll();
	
	Owner findByFirstNameAndLastInitial(String firstName, String lastInitial);
	
	List<Owner> findById(List<Integer> ownerIDlist);
	
	List<Owner> findByDivision(String division);

	Owner findById(Integer id);
}
