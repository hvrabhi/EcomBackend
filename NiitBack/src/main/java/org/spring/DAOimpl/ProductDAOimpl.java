package org.spring.DAOimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.spring.DAO.ProductDAO;
import org.spring.model.Product;
import org.spring.model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class ProductDAOimpl implements ProductDAO {
	
	public ProductDAOimpl(){}

	@Autowired
	SessionFactory sessionFactory;

	public ProductDAOimpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
	}
	@Transactional
    public boolean saveProduct(Product product) 
    {
        try
        {
        
        Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		return true;
        }
        catch(Exception e)
        {
        	System.out.println(e.getMessage());
        return false;
        }
    }	
	
	 @Transactional
     public List<Product> retrieveProduct() 
     {
         Session session=sessionFactory.openSession();
         @SuppressWarnings("rawtypes")
         Query query=session.createQuery("from Product");
         @SuppressWarnings("unchecked")
         List<Product> listProduct=query.list();
         session.close();
         return listProduct;
     }
	 @Transactional
		public Product getProductById(int id) {
			String hql = "from" + " Product" + " where id=" + id;
			@SuppressWarnings("rawtypes")
			Query query = sessionFactory.getCurrentSession().createQuery(hql);

			@SuppressWarnings("unchecked")
			List<Product> listProduct = (List<Product>) query.list();

			if (listProduct != null && !listProduct.isEmpty()) {
				return listProduct.get(0);
			}

			return null;
		}

		@Transactional
		public Product removeProducyById(int id) {
			Product ProductToDelete = new Product();
			ProductToDelete.setId(id);
			sessionFactory.getCurrentSession().delete(ProductToDelete);
			return ProductToDelete;
		}

}
