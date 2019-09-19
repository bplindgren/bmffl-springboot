package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Entry;
import com.repository.EntryRepository;

@Service
public class EntryService {

	@Autowired
	private EntryRepository entryRepository;
	
	public List<Entry> getEntries() {
		return entryRepository.findAll();
	}
}
