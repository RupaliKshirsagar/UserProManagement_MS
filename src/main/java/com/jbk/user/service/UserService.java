package com.jbk.user.service;

import java.util.List;

import com.jbk.user.entity.User;
import com.jbk.user.model.User_Product;

public interface UserService {

	public boolean saveUser(User user);
	public User getUser(String username);
 	public User_Product getUserWithProduct(String username);
	public List<User_Product> userWithProductList();
	
}
