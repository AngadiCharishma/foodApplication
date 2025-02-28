package com.foodapp.dao.interfaces;


import java.util.ArrayList;

import com.foodapp.model.OrderItems;
public interface OrderItemsDAO {
     

                       int insert(OrderItems oi); 
					   ArrayList<OrderItems> fetchAll();
					   OrderItems fetchOne(int i);  
					   int update(int id,int quantity);
					   int delete(int id);
					   
					}














