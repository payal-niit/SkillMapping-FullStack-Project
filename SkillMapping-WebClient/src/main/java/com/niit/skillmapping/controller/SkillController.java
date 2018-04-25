package com.niit.skillmapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.skillmapping.model.Skills;
import com.niit.skillmapping.model.User;
import com.niit.skillmapping.service.SkillService;
import com.niit.skillmapping.service.UserSkillMappingService;

@RestController
@RequestMapping("/api/skill")
public class SkillController {
	
	@Autowired
	private SkillService skillService;
	@Autowired
	private UserSkillMappingService userSkillMappingService;
	
	@GetMapping
	public ResponseEntity<List<Skills>> userList() {
		if (skillService.getSkillList().size() != 0) {
			return new ResponseEntity<List<Skills>>(skillService.getSkillList(), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<List<Skills>>(HttpStatus.NO_CONTENT);
		}
	}

}
