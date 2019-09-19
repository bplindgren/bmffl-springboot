package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Entry;
import com.service.EntryService;

@RestController
@CrossOrigin
@RequestMapping("entry")
public class EntryController {
	
	@Autowired
	private EntryService entryService;
	
	@GetMapping("/all")
	public List<Entry> getEntries() {
		return entryService.getEntries();
	}
}
