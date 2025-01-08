package com.foodapp.dao.interfaces;


import java.util.ArrayList;

import com.foodapp.model.OrderHistory;
public interface OrderHistoryDAO {
     
	
                           int insert(OrderHistory oh); 
						   ArrayList<OrderHistory> fetchAll();
						   OrderHistory fetchOne(int i);  
						   int update(int id,String status);
						   int delete(int id);
						   
						}
















