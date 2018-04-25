package com.niit.skillmapping.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.niit.skillmapping.dao.SkillDAO;
import com.niit.skillmapping.model.Skills;

@Component
@Repository
@Transactional
public class SkillDAOImpl implements SkillDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Skills> getSkillList() {
		
		return sessionFactory.getCurrentSession().createQuery("from Skills").list();
	}

	@Override
	public boolean createSkills(Skills skill) {
		sessionFactory.getCurrentSession().save(skill);
		return true;
	}

	@Override
	public Skills getSkillById(int skill_id) {
		
		String hql = "from Skills where skill_id=" +  skill_id ;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		Skills skill = (Skills) query.uniqueResult();
		return skill;
	}

	@Override
	public Skills getSkillByName(String skill_name) {
		String hql = "from Skills where skill_name=" +  "'" + skill_name +"'" ;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		Skills skill = (Skills) query.uniqueResult();
		return skill;
	}

	@Override
	public boolean updateSkill(Skills skill) {
		sessionFactory.getCurrentSession().update(skill);
		return true;
	}

	@Override
	public boolean deleteSkill(int skill_id) {
		sessionFactory.getCurrentSession().delete(getSkillById(skill_id));
		return true;
	}

}
