package org.spring.DAO;


import java.util.List;

import org.spring.model.Category;

public interface CategoryDAO {

	
	public boolean addCategory(Category category);
	public List<Category> retrieveCategory();
	public Category getCategoryById(int cid);
	public Category removeCategoryById(int cid);
}
