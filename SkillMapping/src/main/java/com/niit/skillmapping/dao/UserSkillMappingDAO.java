package com.niit.skillmapping.dao;

import java.util.List;

import com.niit.skillmapping.model.UserSkillMapping;

public interface UserSkillMappingDAO {
	
	public List<UserSkillMapping> getSkillList();
	public boolean createUserSkillMapping(UserSkillMapping userSkillMapping);
	public UserSkillMapping getUserSkillMappingById(int skill_id);
	public List<UserSkillMapping> getUserSkillMappingByUserId(int user_id);
	public List<UserSkillMapping> getUserSkillMappingBySkillId(int skill_id);
	public UserSkillMapping getSkillByName(String skill_name);
	
	public boolean updateUserSkillMapping(UserSkillMapping userSkillMapping);
	public boolean deleteUserSkillMapping(int userSkill_id);

}
