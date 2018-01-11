package com.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	public  UserDAOImpl(){}
	
	@Autowired
	private SessionFactory sessionFactory;

	
	public UserDAOImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveOrUpdate(User user) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		return true;
		
		
	}

	public List<User> list() {
		
		return null;
	}

	public User getUserById(int user_id) {
		
		return null;
	}

	public void removeUserById(int user_id) {
		
		
	}
	
	@SuppressWarnings("deprecation")
	@Transactional
	public User get(String email) {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(User.class);
		c.add(Restrictions.eq("email", email));

		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) c.list();

		if (listUser != null && !listUser.isEmpty()) {
			return listUser.get(0);
		} else {
			return null;
		}

	}


}
