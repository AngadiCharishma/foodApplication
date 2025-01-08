package com.foodapp.dao.main;


import java.util.ArrayList;
import java.util.Scanner;

import com.foodapp.dao.impl.OrderHistoryDAOimpl;
import com.foodapp.dao.interfaces.OrderHistoryDAO;
import com.foodapp.model.OrderHistory;
public class LaunchOrderHistory {
      
	                          public static void main(String[] args) {
						
	                        	  

						      Scanner sc=new Scanner(System.in);
									
										
							  OrderHistoryDAO ohdaoi= new OrderHistoryDAOimpl();
							  System.out.println("welcome to the Food App\nEnter your choice\n"
										 		+ "1.Insert order history\n"
										 		+ "2.View order history List\n"
										 		+ "3.View Specific order history\n"
										 		+ "4.Update order history\n"
										 		+ "5.Delete order history");
							  int ch=sc.nextInt();
							  switch(ch) {
							  case 1:
							  System.out.println("enter order history id: ");
							  int ohid=sc.nextInt();
							  sc.nextLine();
							  System.out.println("enter order id: ");
							  int oid=sc.nextInt();
							  sc.nextLine();
							  System.out.println("enter user id: ");
							  int uid=sc.nextInt();
							  sc.nextLine();
							  
							  System.out.println("enter total amount: ");
							  int totalAmount=sc.nextInt();
							  sc.nextLine();
							  System.out.println("enter status: ");
							  String status=sc.nextLine();
							  
							  System.out.println("enter order date: ");
							  String orderDate=sc.nextLine();
							  
											
							  
							  
											
							  System.out.println(ohdaoi.insert(new OrderHistory(ohid,oid,uid,totalAmount,status,orderDate))==1?"success":"failure");
							  break;
										
							  case 2:
									for(OrderHistory oh:ohdaoi.fetchAll()) {
										  System.out.println(oh);
									}
									break;
											
							  case 3:
									System.out.println("enter order history id: ");
									ohid=sc.nextInt();
									System.out.println(ohdaoi.fetchOne(ohid));
									break;
							  case 4:
									System.out.println("enter order history id: ");
									ohid=sc.nextInt();
									sc.nextLine();
											
									System.out.println("enter status: ");
									status=sc.nextLine();
									System.out.println(ohdaoi.update(ohid,status)==1?"update success":"update failure");
									break;
							  case 5:
									System.out.println("enter order history id: ");
									ohid=sc.nextInt();
									System.out.println(ohdaoi.delete(ohid)==1?"delete success":"delete failure");
									break;
							  }
									
										 
								         
								         
							  ArrayList<OrderHistory>ohList=ohdaoi.fetchAll();
										 
									
										 
								        
									}

						}











