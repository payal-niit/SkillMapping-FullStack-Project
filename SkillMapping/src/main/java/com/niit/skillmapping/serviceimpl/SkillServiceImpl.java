package com.niit.skillmapping.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.skillmapping.dao.SkillDAO;
import com.niit.skillmapping.model.Skills;
import com.niit.skillmapping.service.SkillService;

@Service
public class SkillServiceImpl implements SkillService {
	@Autowired
	private SkillDAO skillDAO;

	@Override
	public List<Skills> getSkillList() {
		return skillDAO.getSkillList();
	}

	@Override
	public boolean createSkills(Skills skill) {
		if (skillDAO.getSkillById(skill.getSkill_id()) != null) {
			return false;
		} else {
			skillDAO.createSkills(skill);
			return true;
		}
	}

	@Override
	public Skills getSkillById(int skill_id) {
		return skillDAO.getSkillById(skill_id);
	}

	@Override
	public Skills getSkillByName(String skill_name) {
		return skillDAO.getSkillByName(skill_name);
	}

	@Override
	public boolean updateSkill(Skills skill) {
		if (skillDAO.getSkillById(skill.getSkill_id()) != null) {
			skillDAO.updateSkill(skill);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteSkill(int skill_id) {
		if (skillDAO.getSkillById(skill_id) != null) {
			skillDAO.deleteSkill(skill_id);
			return true;
		} else {
			return false;
		}
	}

}
