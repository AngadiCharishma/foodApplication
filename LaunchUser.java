package com.foodapp.dao.main;

import java.util.ArrayList;

import java.util.Scanner;

import com.foodapp.dao.impl.UserDAOimpl;
import com.foodapp.dao.interfaces.UserDAO;
import com.foodapp.model.User;
public class LaunchUser {

	public static void main(String[] args) {
		

		       Scanner sc=new Scanner(System.in);
			
				
				UserDAO udaoi= new UserDAOimpl();
				 System.out.println("welcome to the Restaurant App\nEnter your choice\n"
				 		+ "1.Insert user\n"
				 		+ "2.View user List\n"
				 		+ "3.View Specific user\n"
				 		+ "4.Update user\n"
				 		+ "5.Delete user");
				int ch=sc.nextInt();
				switch(ch) {
				case 1:
					System.out.println("enter user id: ");
					int id=sc.nextInt();
					sc.nextLine();
					System.out.println("enter name: ");
					String name=sc.nextLine();
					System.out.println("enter password: ");
					String password=sc.nextLine();
					System.out.println("enter email: ");
					String email=sc.nextLine();
					System.out.println("enter address: ");
					String address=sc.nextLine();
					
					System.out.println(udaoi.insert(new User(id,name,password,email,address))==1?"success":"failure");
					break;
				
				case 2:
					for(User u:udaoi.fetchAll()) {
						  System.out.println(u);
					 }
					break;
					
				case 3:
					System.out.println("enter id: ");
					 id=sc.nextInt();
					 System.out.println(udaoi.fetchOne(id));
				     break;
				case 4:
					System.out.println("enter id: ");
					id=sc.nextInt();
					sc.nextLine();
					
					System.out.println("enter password: ");
					 password=sc.nextLine();
					 System.out.println(udaoi.update(id,password)==1?"update success":"update failure");
					break;
				case 5:
					System.out.println("enter id: ");
					id=sc.nextInt();
					System.out.println(udaoi.delete(id)==1?"delete success":"delete failure");
				    break;
				}
				 User u=new User(2,"rahul","r123","rahul@gmail.com","punjab");
				 
		         
		         
				 ArrayList<User>uList=udaoi.fetchAll();
				 
			
				 
		        
			}

		


	}


