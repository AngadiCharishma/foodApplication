package com.foodapp.dao.impl;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.dao.db.util.DBConnection;
import com.foodapp.dao.interfaces.OrdersDAO;
import com.foodapp.model.Orders;
public class OrdersDAOimpl implements OrdersDAO{
	

                        static Connection con;
				        static ArrayList<Orders> ordersList=new ArrayList<Orders>();
				        private static final String INSERTQUERY="INSERT INTO ORDERS(ORDERID,USERID,RESTAURANTID,TOTALAMOUNT,STATUS,PAYMENTMODE) VALUES(?,?,?,?,?,?)";
				        private static final String FETCHALL="SELECT * FROM ORDERS";
				        private static final String FETCHONE="SELECT * FROM ORDERS WHERE ORDERID=?";
				        private static final String UPDATE="UPDATE ORDERS SET PAYMENTMODE=? WHERE ORDERID=?";
				        private static final String DELETE="DELETE FROM ORDERS WHERE ORDERID=?";
				        static {
				        	con=DBConnection.connect();
				        	
				        }

						private PreparedStatement pstmt;
						private Statement stmt;
						private ResultSet resultSet;
						private Orders o;
						
					
						

						
						public int insert(Orders o) {
							try {
								pstmt=con.prepareStatement(INSERTQUERY);
								pstmt.setInt(1, o.getOrderId());
								pstmt.setInt(2, o.getUserId());
								pstmt.setInt(3, o.getRestaurantId());
								pstmt.setDouble(4, o.getTotalAmount());
								pstmt.setString(5, o.getStatus());
								pstmt.setString(6, o.getPaymentMode());
								
								return pstmt.executeUpdate();
							}
							catch(Exception e) {
								e.printStackTrace();
							}
							return 0;
						}

						
						public ArrayList<Orders> fetchAll() {
						
							try {
								stmt=con.createStatement();
								resultSet=stmt.executeQuery(FETCHALL);
								ordersList=extractOrdersListFromResultSet(resultSet);
								
							}
							catch(Exception e) {
								e.printStackTrace();
							}
							return ordersList;
							
						}

						
						public Orders fetchOne(int id) {
							try {
								pstmt=con.prepareStatement(FETCHONE);
								pstmt.setInt(1,id);
								resultSet=pstmt.executeQuery();
								
								o=extractOrdersListFromResultSet(resultSet).get(0);
							}
							catch(Exception e) {
								e.printStackTrace();
							}
							return o;
							
						}
						public ArrayList<Orders> extractOrdersListFromResultSet(ResultSet resultSet){
							try {
								while(resultSet.next()) {
									ordersList.add(
											new Orders(
													resultSet.getInt("orderId"),
													resultSet.getInt("userId"),
													resultSet.getInt("restaurantId"),
													
													resultSet.getInt("totalAmount"),
													resultSet.getString("status"),
													resultSet.getString("paymentMode")));
								}
								
							}
							catch(Exception e) {
								e.printStackTrace();
							}
							return ordersList;
						}

						
						public int update(int id, String paymentMode) {
							try {
								pstmt=con.prepareStatement(UPDATE);
								pstmt.setString(1,paymentMode);
								pstmt.setInt(2,id);
								return pstmt.executeUpdate();
								

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








