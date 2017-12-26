package org.spring.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.spring.DAO.CategoryDAO;
import org.spring.DAO.ProductDAO;
import org.spring.DAO.SupplierDAO;
import org.spring.DAO.UserDAO;
import org.spring.DAOimpl.CategoryDAOimpl;
import org.spring.DAOimpl.ProductDAOimpl;
import org.spring.DAOimpl.SupplierDAOimpl;
import org.spring.DAOimpl.UserDAOimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("org.spring")
@EnableTransactionManagement
public class Databaseconfiguration {
	
	
	@Autowired
	@Bean(name="DataSource")
	public DataSource getDataSouce(){
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setDriverClassName("org.h2.Driver");
		datasource.setUrl("jdbc:h2:tcp://localhost/~/Abhilash");
		datasource.setUsername("sa");
		datasource.setPassword("");
		System.out.println("Datasource connection ");
		return datasource;
	}
	
	private Properties getHibernateProperties(){
		Properties properties=new Properties();
		properties.put("hibernate.show_sql","true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		System.out.println("Hibernate Properties");
		return properties;
		
	}
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.scanPackages("org.spring");
		System.out.println("Session");
		
		return sessionBuilder.buildSessionFactory();
		
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		System.out.println("Transaction");
		return transactionManager;
	}
	
	@Autowired
	@Bean(name = "userDAO")
	public UserDAO getUserDAO(SessionFactory sessionFactory) {
	    return new UserDAOimpl(sessionFactory);
	}
	
	@Autowired
	@Bean(name="supplierDAO")
	public SupplierDAO getSupplier(SessionFactory sessionFactory)
	{
		return new SupplierDAOimpl(sessionFactory);
		
	}
	
	@Autowired
	@Bean(name="categoryDAO")
	public CategoryDAO getCategory(SessionFactory sessionFactory)
	{
		return new CategoryDAOimpl(sessionFactory);
		
	}
	@Autowired
	@Bean(name="productDAO")
	public ProductDAO getProduct(SessionFactory sessionFactory)
	{
		return new ProductDAOimpl(sessionFactory);
		
	}
	
}
	
	