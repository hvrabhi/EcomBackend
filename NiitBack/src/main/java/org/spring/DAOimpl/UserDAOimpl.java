package org.spring.DAOimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.spring.DAO.UserDAO;
import org.spring.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOimpl implements UserDAO {
	public UserDAOimpl(){}
	
	@Autowired
	private SessionFactory sessionFactory;

	public UserDAOimpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	public boolean saveUser(Users users) {
		
		try {
			Session session=sessionFactory.openSession();
			Transaction tr=session.beginTransaction();
			session.saveOrUpdate(users);
			tr.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return false;
	}
	public List<Users> getAllUsers() {
		
	
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		List<Users>list=(List<Users>)session.createQuery("from Users");
		tr.commit();
		return list;
	
	
	}
	
}
