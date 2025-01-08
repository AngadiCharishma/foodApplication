package com.foodapp.dao.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.foodapp.dao.impl.OrdersDAOimpl;
import com.foodapp.dao.interfaces.OrdersDAO;
import com.foodapp.model.Orders;
public class LaunchOrders {

	
	                 public static void main(String[] args) {
				

				      Scanner sc=new Scanner(System.in);
							
								
					  OrdersDAO odaoi= new OrdersDAOimpl();
					  System.out.println("welcome to the Food App\nEnter your choice\n"
								 		+ "1.Insert order\n"
								 		+ "2.View order List\n"
								 		+ "3.View Specific order\n"
								 		+ "4.Update order\n"
								 		+ "5.Delete order");
					  int ch=sc.nextInt();
					  switch(ch) {
					  case 1:
					  System.out.println("enter order id: ");
					  int oid=sc.nextInt();
					  sc.nextLine();
					  System.out.println("enter user id: ");
					  int uid=sc.nextInt();
					  sc.nextLine();
					  System.out.println("enter restaurant id: ");
					  int rid=sc.nextInt();
					  sc.nextLine();
					  
					  System.out.println("enter total amount: ");
					  int totalAmount=sc.nextInt();
					  sc.nextLine();
									
					  System.out.println("enter status: ");
					  String status=sc.nextLine();
					  System.out.println("enter payment mode: ");
					  String paymentMode=sc.nextLine();
									
					  System.out.println(odaoi.insert(new Orders(oid,uid,rid,totalAmount,status,paymentMode))==1?"success":"failure");
					  break;
								
					  case 2:
							for(Orders o:odaoi.fetchAll()) {
								  System.out.println(o);
							}
							break;
									
					  case 3:
							System.out.println("enter oid: ");
							oid=sc.nextInt();
							System.out.println(odaoi.fetchOne(oid));
							break;
					  case 4:
							System.out.println("enter oid: ");
							oid=sc.nextInt();
							sc.nextLine();
									
							System.out.println("enter payment mode: ");
							paymentMode=sc.nextLine();
							System.out.println(odaoi.update(oid,paymentMode)==1?"update success":"update failure");
							break;
					  case 5:
							System.out.println("enter oid: ");
							oid=sc.nextInt();
							System.out.println(odaoi.delete(oid)==1?"delete success":"delete failure");
							break;
					  }
							
								 
						         
						         
					  ArrayList<Orders>oList=odaoi.fetchAll();
								 
							
								 
						        
							}

				}







