package com.foodapp.dao.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.foodapp.dao.impl.RestaurantDAOImpl;
import com.foodapp.dao.interfaces.RestaurantDAO;
import com.foodapp.model.Restaurant;
public class LaunchRestaurant {

	public static void main(String[] args) {
		

		                Scanner sc=new Scanner(System.in);
					
						
						RestaurantDAO rdaoi= new RestaurantDAOImpl();
						 System.out.println("welcome to the Food App\nEnter your choice\n"
						 		+ "1.Insert restaurant\n"
						 		+ "2.View restaurant List\n"
						 		+ "3.View Specific restaurant\n"
						 		+ "4.Update restaurant\n"
						 		+ "5.Delete restaurant");
						int ch=sc.nextInt();
						switch(ch) {
						case 1:
							System.out.println("enter user id: ");
							int id=sc.nextInt();
							sc.nextLine();
							System.out.println("enter name: ");
							String name=sc.nextLine();
							System.out.println("enter cusine type: ");
							String cusineType=sc.nextLine();
							System.out.println("enter delivery time: ");
							int deliveryTime=sc.nextInt();
							sc.nextLine();
							System.out.println("enter address: ");
							String address=sc.nextLine();
							System.out.println("enter ratings: ");
							float ratings=sc.nextFloat();
							System.out.println("enter is active: ");
							boolean isActive=sc.nextBoolean();
							sc.nextLine();
							System.out.println("enter image path: ");
							String imagePath=sc.nextLine();
							
							System.out.println(rdaoi.insert(new Restaurant(id,name,cusineType,deliveryTime,address,ratings,isActive,imagePath))==1?"success":"failure");
							break;
						
						case 2:
							for(Restaurant r:rdaoi.fetchAll()) {
								  System.out.println(r);
							}
							 break;
							
						case 3:
							System.out.println("enter id: ");
							 id=sc.nextInt();
							 System.out.println(rdaoi.fetchOne(id));
						     break;
						case 4:
							System.out.println("enter id: ");
							id=sc.nextInt();
							sc.nextLine();
							
							System.out.println("enter ratings: ");
							 ratings=sc.nextFloat();
							 System.out.println(rdaoi.update(id,ratings)==1?"update success":"update failure");
							break;
						case 5:
							System.out.println("enter id: ");
							id=sc.nextInt();
							System.out.println(rdaoi.delete(id)==1?"delete success":"delete failure");
						    break;
						}
						 Restaurant u=new Restaurant(2,"rahul","italian",26,"punjab",4.5f,true,"file.java");
						 
				         
				         
						 List<Restaurant>uList=rdaoi.fetchAll();
						 
					
						 
				        
					}

		}


