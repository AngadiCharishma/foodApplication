package com.foodapp.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.dao.db.util.DBConnection;
import com.foodapp.dao.interfaces.OrderHistoryDAO;
import com.foodapp.model.OrderHistory;
public class OrderHistoryDAOimpl implements OrderHistoryDAO{

	
	                            static Connection con;
						        static ArrayList<OrderHistory> orderHistoryList=new ArrayList<OrderHistory>();
						        private static final String INSERTQUERY="INSERT INTO ORDERHISTORY(ORDERHISTORYID,ORDERID,USERID,TOTALAMOUNT,STATUS,ORDERDATE) VALUES(?,?,?,?,?,?)";
						        private static final String FETCHALL="SELECT * FROM ORDERHISTORY";
						        private static final String FETCHONE="SELECT * FROM ORDERHISTORY WHERE ORDERHISTORYID=?";
						        private static final String UPDATE="UPDATE ORDERHISTORY SET STATUS=? WHERE ORDERHISTORYID=?";
						        private static final String DELETE="DELETE FROM ORDERHISTORY WHERE ORDERHISTORYID=?";
						        static {
						        	con=DBConnection.connect();
						        	
						        }

								private PreparedStatement pstmt;
								private Statement stmt;
								private ResultSet resultSet;
								private OrderHistory oh;
								
							
								

								
								public int insert(OrderHistory oh) {
									try {
										pstmt=con.prepareStatement(INSERTQUERY);
										pstmt.setInt(1, oh.getOrderHistotyId());
										pstmt.setInt(2, oh.getOrderId());
										pstmt.setInt(3, oh.getUserId());
										pstmt.setInt(4, oh.getTotalAmount());
										pstmt.setString(5, oh.getStatus());
										pstmt.setString(6, oh.getOrderDate());
										
										
										return pstmt.executeUpdate();
									}
									catch(Exception e) {
										e.printStackTrace();
									}
									return 0;
								}

								
								public ArrayList<OrderHistory> fetchAll() {
								
									try {
										stmt=con.createStatement();
										resultSet=stmt.executeQuery(FETCHALL);
										orderHistoryList=extractOrderHistoryListFromResultSet(resultSet);
										
									}
									catch(Exception e) {
										e.printStackTrace();
									}
									return orderHistoryList;
									
								}

								
								public OrderHistory fetchOne(int id) {
									try {
										pstmt=con.prepareStatement(FETCHONE);
										pstmt.setInt(1,id);
										resultSet=pstmt.executeQuery();
										
										oh=extractOrderHistoryListFromResultSet(resultSet).get(0);
									}
									catch(Exception e) {
										e.printStackTrace();
									}
									return oh;
									
								}
								public ArrayList<OrderHistory> extractOrderHistoryListFromResultSet(ResultSet resultSet){
									try {
										while(resultSet.next()) {
											orderHistoryList.add(
													new OrderHistory(
															resultSet.getInt("orderHistoryId"),
															resultSet.getInt("orderId"),
															resultSet.getInt("userId"),
															resultSet.getInt("totalAmount"),
															resultSet.getString("status"),
															resultSet.getString("orderDate")));
										}
										
									}
									catch(Exception e) {
										e.printStackTrace();
									}
									return orderHistoryList;
								}

								
								public int update(int id, String status) {
									try {
										pstmt=con.prepareStatement(UPDATE);
										pstmt.setString(1,status);
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












