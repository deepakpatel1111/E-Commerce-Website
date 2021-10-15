package com.basic.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.basic.entity.User;

public class UserDao {
	
	private SessionFactory factory;

	public UserDao(SessionFactory factory) {
		//super();
		this.factory = factory;
	}
	
	public User getUserByEmailAndPassword(String user_email,String user_password) {
		
		User user=null;
		try {
			
			String query = "from User where email=:e and password=:p";
			Session session=this.factory.openSession();
			
			
			  Query q = session.createQuery(query); 
			  q.setParameter("e", user_email);
			  q.setParameter("p", user_password); 
			  user =(User) q.uniqueResult();
			 
			  session.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return user;
	}

}
