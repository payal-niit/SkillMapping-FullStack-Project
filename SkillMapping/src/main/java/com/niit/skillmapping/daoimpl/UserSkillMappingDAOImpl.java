package com.niit.skillmapping.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.niit.skillmapping.dao.UserSkillMappingDAO;
import com.niit.skillmapping.model.UserSkillMapping;

@Repository
@Transactional
public class UserSkillMappingDAOImpl implements UserSkillMappingDAO {

	private SessionFactory sessionFactory;

	@Override
	public List<UserSkillMapping> getSkillList() {
		return sessionFactory.getCurrentSession().createQuery("from UserSkillMapping").list();
	}

	@Override
	public boolean createUserSkillMapping(UserSkillMapping userSkillMapping) {
		sessionFactory.getCurrentSession().save(userSkillMapping);
		return true;
	}

	@Override
	public UserSkillMapping getUserSkillMappingById(int userSkill_id) {
		String hql = "from UserSkillMapping where userSkill_id=" + userSkill_id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		UserSkillMapping userSkillMapping = (UserSkillMapping) query.uniqueResult();
		return userSkillMapping;
	}

	@Override
	public List<UserSkillMapping> getUserSkillMappingByUserId(int user_id) {
		return sessionFactory.getCurrentSession().createQuery("from UserSkillMapping where user_id=" + user_id).list();
	}

	@Override
	public UserSkillMapping getSkillByName(String skill_name) {
		String hql = "from UserSkillMapping where userSkill_id=" + "'" + skill_name + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		UserSkillMapping userSkillMapping = (UserSkillMapping) query.uniqueResult();
		return userSkillMapping;
	}

	@Override
	public boolean updateUserSkillMapping(UserSkillMapping userSkillMapping) {
		sessionFactory.getCurrentSession().update(userSkillMapping);
		return true;
	}

	@Override
	public boolean deleteUserSkillMapping(int userSkill_id) {
		sessionFactory.getCurrentSession().delete(getUserSkillMappingById(userSkill_id));
		return true;
	}

	@Override
	public List<UserSkillMapping> getUserSkillMappingBySkillId(int skill_id) {
		return sessionFactory.getCurrentSession().createQuery("from UserSkillMapping where skill=" + skill_id).list();
	}

}
