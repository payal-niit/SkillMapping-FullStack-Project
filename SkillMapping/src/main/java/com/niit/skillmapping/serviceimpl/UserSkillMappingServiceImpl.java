package com.niit.skillmapping.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.skillmapping.dao.UserSkillMappingDAO;
import com.niit.skillmapping.model.UserSkillMapping;
import com.niit.skillmapping.service.UserSkillMappingService;
@Service
public class UserSkillMappingServiceImpl implements UserSkillMappingService {
	@Autowired
	private UserSkillMappingDAO userSkillMappingDAO;

	@Override
	public List<UserSkillMapping> getSkillList() {
		return userSkillMappingDAO.getSkillList();
	}

	@Override
	public boolean createUserSkillMapping(UserSkillMapping userSkillMapping) {
		userSkillMappingDAO.createUserSkillMapping(userSkillMapping);
		return true;
	}

	@Override
	public UserSkillMapping getUserSkillMappingById(int skill_id) {
		return userSkillMappingDAO.getUserSkillMappingById(skill_id);
	}

	@Override
	public List<UserSkillMapping> getUserSkillMappingByUserId(int user_id) {
		return userSkillMappingDAO.getUserSkillMappingByUserId(user_id);
	}

	@Override
	public List<UserSkillMapping> getUserSkillMappingBySkillId(int skill_id) {
		return userSkillMappingDAO.getUserSkillMappingBySkillId(skill_id);
	}

	@Override
	public UserSkillMapping getSkillByName(String skill_name) {
		return userSkillMappingDAO.getSkillByName(skill_name);
	}

	@Override
	public boolean updateUserSkillMapping(UserSkillMapping userSkillMapping) {
		userSkillMappingDAO.updateUserSkillMapping(userSkillMapping);
		return true;
	}

	@Override
	public boolean deleteUserSkillMapping(int userSkill_id) {
		userSkillMappingDAO.deleteUserSkillMapping(userSkill_id);
		return true;
	}

}
