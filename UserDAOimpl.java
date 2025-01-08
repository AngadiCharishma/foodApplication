package com.foodapp.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.dao.db.util.DBConnection;
import com.foodapp.dao.interfaces.UserDAO;
import com.foodapp.model.User;
public class UserDAOimpl implements UserDAO{
	

            static Connection con;
	        static ArrayList<User> userList=new ArrayList<User>();
	        private static final String INSERTQUERY="INSERT INTO USER(USERID,USERNAME,PASSWORD,EMAIL,ADDRESS) VALUES(?,?,?,?,?)";
	        private static final String FETCHALL="SELECT * FROM USER";
	        private static final String FETCHONE="SELECT * FROM USER WHERE USERID=?";
	        private static final String UPDATE="UPDATE USER SET PASSWORD=? WHERE USERID=?";
	        private static final String DELETE="DELETE FROM USER WHERE USERID=?";
	        static {
	        	con=DBConnection.connect();
	        	
	        }

			private PreparedStatement pstmt;
			private Statement stmt;
			private ResultSet resultSet;
			private User u;
			

			
			public int insert(User u) {
				try {
					pstmt=con.prepareStatement(INSERTQUERY);
					pstmt.setInt(1, u.getUserId());
					pstmt.setString(2, u.getUserName());
					pstmt.setString(3, u.getPassword());
					pstmt.setString(4, u.getEmail());
					pstmt.setString(5, u.getAddress());
					return pstmt.executeUpdate();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				return 0;
			}

			
			public ArrayList<User> fetchAll() {
				try {
					stmt=con.createStatement();
					resultSet=stmt.executeQuery(FETCHALL);
					userList=extractUserListFromResultSet(resultSet);
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				return userList;
				
			}

			
			public User fetchOne(int id) {
				try {
					pstmt=con.prepareStatement(FETCHONE);
					pstmt.setInt(1,id);
					resultSet=pstmt.executeQuery();
					
					u=extractUserListFromResultSet(resultSet).get(0);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				return u;
				
			}
			public ArrayList<User> extractUserListFromResultSet(ResultSet resultSet){
				try {
					while(resultSet.next()) {
						userList.add(
								new User(
										resultSet.getInt("userId"),
										resultSet.getString("userName"),
										resultSet.getString("password"),
										resultSet.getString("email"),
										resultSet.getString("address")));
					}
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				return userList;
			}

			
			public int update(int id, String password) {
				try {
					pstmt=con.prepareStatement(UPDATE);
					pstmt.setString(1,password);
					pstmt.setInt(2,id);
					return pstmt.executeUpdate();
					
//					s=extractStudentListFromResultSet(resultSet).get(0);
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


