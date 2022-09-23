package com.jbk.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.user.entity.User;
import com.jbk.user.model.User_Product;
import com.jbk.user.service.UserService;

@RestController
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping(value="/saveUser")   // in postman " 8080/user/saveUser " post===> use in this way
	public ResponseEntity<String> saveUser(@RequestBody User user){
	boolean isAdded = service.saveUser(user);
	if(isAdded) {
		return new ResponseEntity<String> ("User saved !!",HttpStatus.CREATED);
	}else {
		
		return new ResponseEntity<String> ("User Not saved..Already Exists !!",HttpStatus.OK);
		
	}
	}
	
	@GetMapping(value="/getUser/{username}")  // user/getUser/Rupali
	public ResponseEntity<User> getUser(@PathVariable String username){
		User user=service.getUser(username);
		if(user!=null) {
			return new ResponseEntity<User> (user,HttpStatus.OK);
		}else {
			
			return new ResponseEntity<User> (user,HttpStatus.NO_CONTENT);
			
		}
		
	}
	@GetMapping(value="/getUserWithProduct/{username}") // for single user with product
	public ResponseEntity<User_Product> getUserWithProduct(@PathVariable String username){
	
		User_Product user_Product =	service.getUserWithProduct(username);
		
		return new ResponseEntity<User_Product>(user_Product,HttpStatus.OK);
		
	}
	@GetMapping(value = "/userWithProductList")
	public ResponseEntity<List <User_Product>> userWithProductList() {
		try {
		List<User_Product> userProList = this.service.userWithProductList();
		return new ResponseEntity<List <User_Product>>(userProList,HttpStatus.OK);

		}catch(Exception e) {
	
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

}
}
}
