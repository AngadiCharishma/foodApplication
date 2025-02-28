package com.foodapp.dao.interfaces;


import java.util.ArrayList;

import com.foodapp.model.Orders;
public interface OrdersDAO {
     
	
                   int insert(Orders o); 
				   ArrayList<Orders> fetchAll();
				   Orders fetchOne(int i);  
				   int update(int id,String paymentMode);
				   int delete(int id);
				   
				}












