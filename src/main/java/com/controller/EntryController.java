package com.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Entry;
import com.entity.NewEntry;
import com.entity.User;
import com.service.EntryService;
import com.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("entry")
public class EntryController {
	
	@Autowired
	private EntryService entryService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/all")
	public List<Entry> getEntries() {
		return entryService.getEntries();
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createEntry(@RequestBody NewEntry entry) {
		// Get info for Entry object
		String title = entry.getTitle();
		String content = entry.getContent();		
		User user = userService.findById(entry.getUserId());
		
		// Create and save entry
		Entry entryToSave = new Entry(title, content, user);
		entryService.save(entryToSave);

		return new ResponseEntity<>(entry, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable long id) {
		if (entryService.findById(id) == null) {
			return new ResponseEntity<String>(("Unable to delete"), HttpStatus.NOT_FOUND);
		} else {
			entryService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
