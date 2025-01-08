package com.foodapp.dao.main;


import java.util.ArrayList;
import java.util.Scanner;

import com.foodapp.dao.impl.OrderItemsDAOimpl;
import com.foodapp.dao.interfaces.OrderItemsDAO;
import com.foodapp.model.OrderItems;
public class LaunchOrderItems {
        
	

	                      public static void main(String[] args) {
					

					      Scanner sc=new Scanner(System.in);
								
									
						  OrderItemsDAO oidaoi= new OrderItemsDAOimpl();
						  System.out.println("welcome to the Food App\nEnter your choice\n"
									 		+ "1.Insert order item\n"
									 		+ "2.View order items List\n"
									 		+ "3.View Specific order item\n"
									 		+ "4.Update order item\n"
									 		+ "5.Delete order item");
						  int ch=sc.nextInt();
						  switch(ch) {
						  case 1:
						  System.out.println("enter order item id: ");
						  int id=sc.nextInt();
						  sc.nextLine();
						  System.out.println("enter order id: ");
						  int oid=sc.nextInt();
						  sc.nextLine();
						  System.out.println("enter menu id: ");
						  int mid=sc.nextInt();
						  sc.nextLine();
						  
						  System.out.println("enter quantity: ");
						  int quantity=sc.nextInt();
						  sc.nextLine();
										
						  System.out.println("enter item total: ");
						  int itemTotal=sc.nextInt();
						  sc.nextLine();
						  
										
						  System.out.println(oidaoi.insert(new OrderItems(id,oid,mid,quantity,itemTotal))==1?"success":"failure");
						  break;
									
						  case 2:
								for(OrderItems oi:oidaoi.fetchAll()) {
									  System.out.println(oi);
								}
								break;
										
						  case 3:
								System.out.println("enter id: ");
								id=sc.nextInt();
								System.out.println(oidaoi.fetchOne(id));
								break;
						  case 4:
								System.out.println("enter id: ");
								id=sc.nextInt();
								sc.nextLine();
										
								System.out.println("enter quantity: ");
								quantity=sc.nextInt();
								System.out.println(oidaoi.update(id,quantity)==1?"update success":"update failure");
								break;
						  case 5:
								System.out.println("enter id: ");
								id=sc.nextInt();
								System.out.println(oidaoi.delete(id)==1?"delete success":"delete failure");
								break;
						  }
								
									 
							         
							         
						  ArrayList<OrderItems>oiList=oidaoi.fetchAll();
									 
								
									 
							        
								}

					}









