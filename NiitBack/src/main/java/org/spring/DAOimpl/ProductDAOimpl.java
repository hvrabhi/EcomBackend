package org.spring.DAOimpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.spring.DAO.ProductDAO;
import org.spring.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOimpl implements ProductDAO{
	public ProductDAOimpl(){}
	
	@Autowired
    SessionFactory sessionFactory;
	
	
	public ProductDAOimpl(SessionFactory sessionFactory) {
	this.sessionFactory=sessionFactory;
	}

	@Transactional
	public boolean addProduct(Product product) 
	{
		 try
	      {
	      Session session=sessionFactory.getCurrentSession();
		  session.saveOrUpdate(product);
	      return true;
	      }
	      catch(Exception e)
	      {
	      return false;
	      }
	}

}
