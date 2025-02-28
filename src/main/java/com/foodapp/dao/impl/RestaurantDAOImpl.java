package com.foodapp.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.dao.db.util.DBConnection;
import com.foodapp.dao.interfaces.RestaurantDAO;
import com.foodapp.model.Restaurant;
public class RestaurantDAOImpl implements RestaurantDAO{
	
	
	
		

	            static Connection con;
		        static ArrayList<Restaurant> restaurantList=new ArrayList<Restaurant>();
		        private static final String INSERTQUERY="INSERT INTO RESTAURANT(RestaurantID,NAME,CUSINETYPE,DELIVERYTIME,ADDRESS,RATINGS,ISACTIVE,IMAGEPATH) VALUES(?,?,?,?,?,?,?,?)";
		        private static final String FETCHALL="SELECT * FROM RESTAURANT";
		        private static final String FETCHONE="SELECT * FROM RESTAURANT WHERE RESTAURANTID=?";
		        private static final String UPDATE="UPDATE RESTAURANT SET RATINGS=? WHERE RESTAURANTID=?";
		        private static final String DELETE="DELETE FROM RESTAURANT WHERE RESTAURANTID=?";
		        static {
		        	con=DBConnection.connect();
		        	
		        }

				private PreparedStatement pstmt;
				private Statement stmt;
				private ResultSet resultSet;
				private Restaurant r;
			
				

				
				public int insert(Restaurant r) {
					try {
						pstmt=con.prepareStatement(INSERTQUERY);
						pstmt.setInt(1, r.getRestaurantId());
						pstmt.setString(2, r.getName());
						pstmt.setString(3, r.getCusineType());
						pstmt.setInt(4, r.getDeliveryTime());
						pstmt.setString(5, r.getAddress());
						pstmt.setFloat(6, r.getRatings());
						pstmt.setBoolean(7, r.getisActive());
						pstmt.setString(8, r.getImagePath());
						return pstmt.executeUpdate();
					}
					catch(Exception e) {
						e.printStackTrace();
					}
					return 0;
				}

				
				public ArrayList<Restaurant> fetchAll() {
					try {
						stmt=con.createStatement();
						resultSet=stmt.executeQuery(FETCHALL);
						restaurantList=extractRestaurantListFromResultSet(resultSet);
						
					}
					catch(Exception e) {
						e.printStackTrace();
					}
					return restaurantList;
					
				}

				
				public Restaurant fetchOne(int id) {
					try {
						pstmt=con.prepareStatement(FETCHONE);
						pstmt.setInt(1,id);
						resultSet=pstmt.executeQuery();
						
						r=extractRestaurantListFromResultSet(resultSet).get(0);
					}
					catch(Exception e) {
						e.printStackTrace();
					}
					return r;
					
				}
				public ArrayList<Restaurant> extractRestaurantListFromResultSet(ResultSet resultSet){
					try {
						while(resultSet.next()) {
							restaurantList.add(
									new Restaurant(
											resultSet.getInt("restaurantId"),
											resultSet.getString("name"),
											resultSet.getString("cusineType"),
											resultSet.getInt("deliveryTime"),
											resultSet.getString("address"),
											resultSet.getFloat("ratings"),
											resultSet.getBoolean("isActive"),
											resultSet.getString("imagePath")));
						}
						
					}
					catch(Exception e) {
						e.printStackTrace();
					}
					return restaurantList;
				}

				
				public int update(int id, float ratings) {
					try {
						pstmt=con.prepareStatement(UPDATE);
						pstmt.setFloat(1,ratings);
						pstmt.setInt(2,id);
						return pstmt.executeUpdate();
						
//						s=extractStudentListFromResultSet(resultSet).get(0);
					}
					catch(Exception e) {
						e.printStackTrace();
						return 0;
					}
					
				}

				
				public int delete(int id) {
					try {
						pstmt=con.prepareStatement(DELETE);
						
						pstmt.setInt(1,id);
						return pstmt.executeUpdate();
					}
					catch(Exception e) {
						e.printStackTrace();
						return 0;
					}
					
				}
		}




