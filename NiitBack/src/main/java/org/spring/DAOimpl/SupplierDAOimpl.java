package org.spring.DAOimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.spring.DAO.SupplierDAO;
import org.spring.model.Category;
import org.spring.model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SupplierDAOimpl implements SupplierDAO {
	
	
	public SupplierDAOimpl(){}
	
	@Autowired
    private SessionFactory sessionFactory;
	
	  public  SupplierDAOimpl(SessionFactory sessionFactory)
	  {
		  this.sessionFactory=sessionFactory;
	  }
	  	
	  
	  	@Transactional
	    public boolean addSupplier(Supplier supplier) 
	    {
	        try
	        {
	        
	        Session session=sessionFactory.getCurrentSession();
			session.saveOrUpdate(supplier);
			return true;
	        }
	        catch(Exception e)
	        {
	        	System.out.println(e.getMessage());
	        return false;
	        }
	    }	
	  	
	  	 @Transactional
	     public List<Supplier> retrieveSupplier() 
	     {
	         Session session=sessionFactory.openSession();
	         @SuppressWarnings("rawtypes")
	         Query query=session.createQuery("from Supplier");
	         @SuppressWarnings("unchecked")
	         List<Supplier> listSupplier=query.list();
	         session.close();
	         return listSupplier;
	     }
}
