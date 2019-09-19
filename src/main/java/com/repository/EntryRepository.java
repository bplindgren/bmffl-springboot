package com.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Entry;

public interface EntryRepository extends JpaRepository<Entry, Long> {

	List<Entry> findAll();
}
