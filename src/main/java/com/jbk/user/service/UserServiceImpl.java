package com.jbk.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jbk.user.dao.UserDao;
import com.jbk.user.entity.User;
import com.jbk.user.model.Product;
import com.jbk.user.model.User_Product;


@Service
public class UserServiceImpl implements UserService {

	  @Autowired
      private UserDao dao;
	  
	  @Autowired
	 private RestTemplate restTemplate;
	  
	  
	
	
	
	@Override
	public boolean saveUser(User user) {
		
		return dao.saveUser(user);
	}

	@Override
	public User getUser(String username) {
		
		return dao.getUser(username);
	}

	@Override
	public User_Product getUserWithProduct(String username) {
		User_Product user_Product=new User_Product();
	try {	
		
	User user=getUser(username);
	System.out.println("User : "+user);
    Product product=restTemplate.getForObject("http://localhost:8081/product/getProductById?productId="+user.getProductId(), Product.class);
    System.out.println("Product : "+product);
    user_Product.setUser(user);
    user_Product.setProduct(product);
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	return user_Product;
	}

	@Override
	public List<User_Product> userWithProductList() {
		
		List<User_Product> al=new ArrayList<>();
		User_Product user_Product=new User_Product();
		List<User> user=dao.findAll();
		System.out.println("user>>"+user);
		for (User usr : user) {
			Product product=restTemplate.getForObject("http://localhost:8081/product/getProductById/"+usr.getProductId(), Product.class);
			System.out.println("product>>"+product);
			user_Product.setProduct(product);
			user_Product.setUser(usr);
			al.add(user_Product);
		}
			
		return al;
		
		
		
		
	}
//		User_Product user_Product=new User_Product();
//		List<User_Product> list=null;
//		try {
//			list=session.createCriteria(User_Product.class).list();
	//		User user=getUser(username);
	  //      User_Product user_Product1=getUserWithProduct(username);                           //getUser(username);
		//	System.out.println("User : "+user_Procuct);
//		    user_Product=restTemplate.ge  //("http://http://localhost:8080/user/getUserWithProduct?username="+user_Product., Product.class);
//		    System.out.println("Product : "+product);
	//	    user_Product.setUser(user);
	//	    user_Product.setProduct(product);
//		
//		}catch(Exception e) {
//			e.printStackTrace();
//			
//		}
//		
//		return null;
//	}

}
