package com.foodapp.dao.main;


import java.util.ArrayList;
import java.util.Scanner;

import com.foodapp.dao.impl.MenuDAOimpl;
import com.foodapp.dao.interfaces.MenuDAO;
import com.foodapp.model.Menu;
public class LaunchMenu {
	

	
	                      public static void main(String[] args) {
			

			                Scanner sc=new Scanner(System.in);
						
							
							MenuDAO mdaoi= new MenuDAOimpl();
							 System.out.println("welcome to the Food App\nEnter your choice\n"
							 		+ "1.Insert menu\n"
							 		+ "2.View menu List\n"
							 		+ "3.View Specific menu\n"
							 		+ "4.Update menu\n"
							 		+ "5.Delete menu");
							int ch=sc.nextInt();
							switch(ch) {
							case 1:
								System.out.println("enter menu id: ");
								int mid=sc.nextInt();
								sc.nextLine();
								System.out.println("enter restaurant id: ");
								int rid=sc.nextInt();
								sc.nextLine();
								System.out.println("enter name: ");
								String name=sc.nextLine();
								System.out.println("enter description: ");
								String description=sc.nextLine();
								System.out.println("enter price: ");
								int price=sc.nextInt();
								sc.nextLine();
								
								System.out.println("enter is available: ");
								boolean isAvailable=sc.nextBoolean();
								sc.nextLine();
								System.out.println("enter image path: ");
								String imagePath=sc.nextLine();
								
								System.out.println(mdaoi.insert(new Menu(mid,rid,name,description,price,isAvailable,imagePath))==1?"success":"failure");
								break;
							
							case 2:
								for(Menu m:mdaoi.fetchAll()) {
									  System.out.println(m);
								}
								 break;
								
							case 3:
								System.out.println("enter mid: ");
								 mid=sc.nextInt();
								 System.out.println(mdaoi.fetchOne(mid));
							     break;
							case 4:
								System.out.println("enter mid: ");
								mid=sc.nextInt();
								sc.nextLine();
								
								System.out.println("enter price: ");
								 price=sc.nextInt();
								 System.out.println(mdaoi.update(mid,price)==1?"update success":"update failure");
								break;
							case 5:
								System.out.println("enter mid: ");
								mid=sc.nextInt();
								System.out.println(mdaoi.delete(mid)==1?"delete success":"delete failure");
							    break;
							}
//							Menu m=new Menu(2,"rahul","italian",26,"punjab",4.5f,true,"file.java");
							 
					         
					         
							 ArrayList<Menu>mList=mdaoi.fetchAll();
							 
						
							 
					        
						}

			}





