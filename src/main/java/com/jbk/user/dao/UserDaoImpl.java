package com.jbk.user.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.user.entity.User;
import com.jbk.user.model.User_Product;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sf;

	@Override
	public User getUser(String username) {
		Session session = sf.openSession();
		User user=null;
		try {
			user=session.get(User.class, username);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return user;
	}

	@Override
	public boolean saveUser(User user) {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		boolean isAdded = false;
		
		try {
			User usr = session.get(User.class,user.getUsername());
			
			if(usr==null){
				session.save(user);
				tx.commit();
				isAdded = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return isAdded;
		
	}

	@Override
	public List<User> findAll() {
		Session session = sf.openSession();
		List<User> list=null;
		try {

			list=session.createCriteria(User.class).list();
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			session.close();
		}
		return list;
	}
}

//	@Override
//	public List<User_Product> userWithProductList() {
//		Session session = sf.openSession();
//		List<User_Product> list=null;
//		try {
//			Criteria criteria=session.createCriteria(User.class);//?not use
//			List<User> userList =  criteria.list();//?not use
//			list=session.createCriteria(User_Product.class).list();
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//			
//		}finally {
//			session.close();
//		}
//		return list;
//	}
//	}

