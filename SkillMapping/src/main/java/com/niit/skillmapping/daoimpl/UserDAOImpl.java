package com.niit.skillmapping.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.niit.skillmapping.dao.UserDAO;
import com.niit.skillmapping.model.User;

@Component
@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	public UserDAOImpl(SessionFactory sessionFactory2) {
		// TODO Auto-generated constructor stub
	}

	public List<User> getUserList() {
		List<User> userList = sessionFactory.getCurrentSession().createQuery("from User").list();
		return userList;
	}

	public boolean createUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		return true;
		
	}

	public String getUserListByJSON() {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUserById2(int user_id) {
		String hql = "from User where user_id=" +  user_id ;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<User> userList = (List<User>) query.list();
		
		if (userList != null && !userList.isEmpty()) {
			return userList.get(0);
		}
		return null;
	}
	public User getUserById(int user_id) {
		String hql = "from User where user_id=" +  user_id ;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		User user = (User) query.uniqueResult();
		return user;
	}

	public User getUserByUsername(String username) {
		String hql = "from User where email_id=" + "'" + username + "'" ;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<User> userList = (List<User>) query.list();
		
		if (userList != null && !userList.isEmpty()) {
			return userList.get(0);
		}
		return null;
	}

	public List<User> getUserforActivation() {
		String hql = "from User where status = false" ;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<User> userList = (List<User>) query.list();
		
		if (userList != null && !userList.isEmpty()) {
			return userList;
		}
		return null;
	}

	public boolean getUserActivated(int user_id) {		
		//String hql = "from User where user_id="+user_id;
		//sessionFactory.getCurrentSession().createQuery(hql).setParameter("status", true).executeUpdate();		
		sessionFactory.getCurrentSession().createQuery("update User set status = true where user_id = "+user_id).executeUpdate();
		return true;		
	}

	public List<User> getUserOnSearch(String fname) {
		String hql = "from User where status=true and fname like "+ "'%"+fname + "%'" ;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<User> userList = (List<User>) query.list();
		
		if (userList != null && !userList.isEmpty()) {
			return userList;
		}
		return null;
	}

	public boolean updateUser(User user) {
		 sessionFactory.getCurrentSession().update(user);
		 return true;
		
	}

	public boolean deleteUser(int user_id) {
		sessionFactory.getCurrentSession().delete(getUserById(user_id));
		return true;
	}
}
