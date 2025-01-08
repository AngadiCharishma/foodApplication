package com.foodapp.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dao.db.util.DBConnection;
import com.foodapp.dao.interfaces.MenuDAO;
import com.foodapp.model.Menu;
public class MenuDAOimpl implements MenuDAO{
	


                    static Connection con;
			        static ArrayList<Menu> menuList=new ArrayList<Menu>();
			        private static final String INSERTQUERY="INSERT INTO MENU(MENUID,RESTAURANTID,NAME,DESCRIPTION,PRICE,ISAVAILABLE,IMAGEPATH) VALUES(?,?,?,?,?,?,?)";
			        private static final String FETCHALL="SELECT * FROM MENU";
			        private static final String FETCHONE="SELECT * FROM MENU WHERE MENUID=?";
			        private static final String UPDATE="UPDATE MENU SET PRICE=? WHERE MENUID=?";
			        private static final String DELETE="DELETE FROM MENU WHERE MENUID=?";
			        private static final String FETCHBYRID="SELECT * FROM MENU WHERE RESTAURANTID=?";
			        static {
			        	con=DBConnection.connect();
			        	
			        }

					private PreparedStatement pstmt;
					private Statement stmt;
					private ResultSet resultSet;
					private Menu m;
					
				
					

					
					public int insert(Menu m) {
						try {
							pstmt=con.prepareStatement(INSERTQUERY);
							pstmt.setInt(1, m.getMenuId());
							pstmt.setInt(2, m.getRestaurantId());
							pstmt.setString(3, m.getName());
							pstmt.setString(4, m.getDescription());
							pstmt.setInt(5, m.getPrice());
							pstmt.setBoolean(6, m.getisAvailable());
							pstmt.setString(7, m.getImagePath());
							return pstmt.executeUpdate();
						}
						catch(Exception e) {
							e.printStackTrace();
						}
						return 0;
					}
					
					public List<Menu> fetchMenuByRestaurantId(int id) {
					    List<Menu> menuList = new ArrayList<>();
					    try {
					        PreparedStatement pstmt = con.prepareStatement(FETCHBYRID);
					        pstmt.setInt(1, id);
					        ResultSet resultSet = pstmt.executeQuery();
					        
					        while(resultSet.next()) {
								menuList.add(
										new Menu(
												resultSet.getInt("menuId"),
												resultSet.getInt("restaurantId"),
												resultSet.getString("name"),
												resultSet.getString("description"),
												resultSet.getInt("price"),
												resultSet.getBoolean("isAvailable"),
												resultSet.getString("imagePath")));
							}
					    } catch (Exception e) {
					        e.printStackTrace();
					    }
					    
					    return menuList;
					}


					
					public ArrayList<Menu> fetchAll() {
					
						try {
							stmt=con.createStatement();
							resultSet=stmt.executeQuery(FETCHALL);
							menuList=extractMenuListFromResultSet(resultSet);
							
						}
						catch(Exception e) {
							e.printStackTrace();
						}
						return menuList;
						
					}

					
					public Menu fetchOne(int id) {
						try {
							pstmt=con.prepareStatement(FETCHONE);
							pstmt.setInt(1,id);
							resultSet=pstmt.executeQuery();
							
							m=extractMenuListFromResultSet(resultSet).get(0);
						}
						catch(Exception e) {
							e.printStackTrace();
						}
						return m;
						
					}
					public ArrayList<Menu> extractMenuListFromResultSet(ResultSet resultSet){
						try {
							while(resultSet.next()) {
								menuList.add(
										new Menu(
												resultSet.getInt("menuId"),
												resultSet.getInt("restaurantId"),
												resultSet.getString("name"),
												resultSet.getString("description"),
												resultSet.getInt("price"),
												resultSet.getBoolean("isAvailable"),
												resultSet.getString("imagePath")));
							}
							
						}
						catch(Exception e) {
							e.printStackTrace();
						}
						return menuList;
					}

					
					public int update(int id, int price) {
						try {
							pstmt=con.prepareStatement(UPDATE);
							pstmt.setInt(1,price);
							pstmt.setInt(2,id);
							return pstmt.executeUpdate();
							
//							s=extractStudentListFromResultSet(resultSet).get(0);
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






