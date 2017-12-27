package org.spring.DAO;

import java.util.List;

import org.spring.model.Users;


public interface UserDAO {
	
	public boolean saveUser(Users users);
	public List<Users> getAllUsers();
}
