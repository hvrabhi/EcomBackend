package org.spring.DAOimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.spring.DAO.CategoryDAO;
import org.spring.model.Category;
import org.spring.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDAOimpl implements CategoryDAO {
	
	public CategoryDAOimpl(){}
	
	@Autowired
    private SessionFactory sessionFactory;
	
	  public  CategoryDAOimpl(SessionFactory sessionFactory)
	  {
		  this.sessionFactory=sessionFactory;
	  }
	  	
	  
	  	@Transactional
	    public boolean addCategory(Category category) 
	    {
	        try
	        {
	        
	        Session session=sessionFactory.getCurrentSession();
			session.saveOrUpdate(category);
			return true;
	        }
	        catch(Exception e)
	        {
	        	System.out.println(e.getMessage());
	        return false;
	        }
	    }	
	  	
	  	 @Transactional
	     public List<Category> retrieveCategory() 
	     {
	         Session session=sessionFactory.openSession();
	         @SuppressWarnings("rawtypes")
	         Query query=session.createQuery("from Category");
	         @SuppressWarnings("unchecked")
	         List<Category> listCategory=query.list();
	         session.close();
	         return listCategory;
	     }

	  	@Transactional
		public Category getCategoryById(int cid) {
			String hql = "from"+" Category"+" where id=" + cid;
			@SuppressWarnings("rawtypes")
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			
			@SuppressWarnings("unchecked")
			List<Category> listCategory = (List<Category>) query.list();
			
			if (listCategory != null && !listCategory.isEmpty()) {
				return listCategory.get(0);
			}
			
			return null;
		}



		@Transactional
		public Category removeCategoryById(int cid) {
			Category CategoryToDelete = new Category();
			CategoryToDelete.setId(cid);
			sessionFactory.getCurrentSession().delete(CategoryToDelete);
			return CategoryToDelete;
		}


}
