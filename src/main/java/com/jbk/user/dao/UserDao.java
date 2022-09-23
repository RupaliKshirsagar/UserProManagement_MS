package com.jbk.user.dao;

import java.util.List;

import com.jbk.user.entity.User;
import com.jbk.user.model.User_Product;

public interface UserDao {

	public User getUser(String username);

	public boolean saveUser(User user);

	public List<User> findAll();

	//public List<User_Product> userWithProductList();

}
