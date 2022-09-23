package com.jbk.user.model;

import com.jbk.user.entity.User;

public class User_Product {

	private User user;
	private Product product;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public User_Product(User user, Product product) {
		super();
		this.user = user;
		this.product = product;
	}
	public User_Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User_Product [user=" + user + ", product=" + product + "]";
	}
	
}
