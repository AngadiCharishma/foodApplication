
package com.foodapp.dao.interfaces;

import java.util.ArrayList;
import java.util.List;

import com.foodapp.model.Restaurant;

public interface RestaurantDAO {
	
           int insert(Restaurant r); 
		   List<Restaurant> fetchAll();
		  
		   Restaurant fetchOne(int i);  
		   int update(int id,float ratings);
		   int delete(int id);
		   
		}








