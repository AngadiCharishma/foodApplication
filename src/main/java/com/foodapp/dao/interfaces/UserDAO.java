package com.foodapp.dao.interfaces;

import java.util.ArrayList;

import com.foodapp.model.User;
public interface UserDAO {
	
       int insert(User u); 
	   ArrayList<User> fetchAll();
	   User fetchOne(int i);  
	   int update(int id,String password);
	   int delete(int id);
	   
	}






