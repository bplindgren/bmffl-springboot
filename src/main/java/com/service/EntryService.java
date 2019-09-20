package com.service;

import java.util.List;
import java.util.Optional;

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
	
	public Optional<Entry> findById(long id) {
		return entryRepository.findById(id);
	}
	
	public Entry save(Entry entry) {
		entryRepository.save(entry);
		return entry;
	}

	public void deleteById(long id) {
		entryRepository.deleteById(id);
	}
}
