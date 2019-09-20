package com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Entry;

public interface EntryRepository extends JpaRepository<Entry, Long> {

	List<Entry> findAll();
	
	Optional<Entry> findById(long id);
}
