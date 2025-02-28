package com.foodapp.dao.interfaces;


import java.util.ArrayList;
import java.util.List;

import com.foodapp.model.Menu;
public interface MenuDAO {
	

	           int insert(Menu m); 
			   ArrayList<Menu> fetchAll();
			   Menu fetchOne(int i); 
			   List<Menu> fetchMenuByRestaurantId(int id);
			   int update(int id,int price);
			   int delete(int id);
//			   Menu getMenu(int itemId);
			   
			}










