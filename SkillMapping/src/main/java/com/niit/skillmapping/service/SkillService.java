package com.niit.skillmapping.service;

import java.util.List;

import com.niit.skillmapping.model.Skills;

public interface SkillService {
	public List<Skills> getSkillList();
	public boolean createSkills(Skills skill);
	public Skills getSkillById(int skill_id);
	public Skills getSkillByName(String username);
	
	public boolean updateSkill(Skills skill);
	public boolean deleteSkill(int skill_id);
}
