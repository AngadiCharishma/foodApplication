package com.foodapp.dao.impl;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.dao.db.util.DBConnection;
import com.foodapp.dao.interfaces.OrderItemsDAO;

import com.foodapp.model.OrderItems;
public class OrderItemsDAOimpl implements OrderItemsDAO {
       
	

                            static Connection con;
					        static ArrayList<OrderItems> orderItemsList=new ArrayList<OrderItems>();
					        private static final String INSERTQUERY="INSERT INTO ORDERITEMS(ORDERITEMID,ORDERID,MENUID,QUANTITY,ITEMTOTAL) VALUES(?,?,?,?,?)";
					        private static final String FETCHALL="SELECT * FROM ORDERITEMS";
					        private static final String FETCHONE="SELECT * FROM ORDERITEMS WHERE ORDERITEMID=?";
					        private static final String UPDATE="UPDATE ORDERITEMS SET QUANTITY=? WHERE ORDERITEMID=?";
					        private static final String DELETE="DELETE FROM ORDERITEMS WHERE ORDERITEMID=?";
					        static {
					        	con=DBConnection.connect();
					        	
					        }

							private PreparedStatement pstmt;
							private Statement stmt;
							private ResultSet resultSet;
							private OrderItems oi;
							
						
							

							
							public int insert(OrderItems oi) {
								try {
									pstmt=con.prepareStatement(INSERTQUERY);
									pstmt.setInt(1, oi.getOrderItemId());
									pstmt.setInt(2, oi.getOrderId());
									pstmt.setInt(3, oi.getMenuId());
									pstmt.setInt(4, oi.getQuantity());
									pstmt.setInt(5, oi.getItemTotal());
									
									
									return pstmt.executeUpdate();
								}
								catch(Exception e) {
									e.printStackTrace();
								}
								return 0;
							}

							
							public ArrayList<OrderItems> fetchAll() {
							
								try {
									stmt=con.createStatement();
									resultSet=stmt.executeQuery(FETCHALL);
									orderItemsList=extractOrderItemsListFromResultSet(resultSet);
									
								}
								catch(Exception e) {
									e.printStackTrace();
								}
								return orderItemsList;
								
							}

							
							public OrderItems fetchOne(int id) {
								try {
									pstmt=con.prepareStatement(FETCHONE);
									pstmt.setInt(1,id);
									resultSet=pstmt.executeQuery();
									
									oi=extractOrderItemsListFromResultSet(resultSet).get(0);
								}
								catch(Exception e) {
									e.printStackTrace();
								}
								return oi;
								
							}
							public ArrayList<OrderItems> extractOrderItemsListFromResultSet(ResultSet resultSet){
								try {
									while(resultSet.next()) {
										orderItemsList.add(
												new OrderItems(
														resultSet.getInt("orderItemId"),
														resultSet.getInt("orderId"),
														resultSet.getInt("menuId"),
														
														resultSet.getInt("quantity"),
														resultSet.getInt("itemTotal")));
									}
									
								}
								catch(Exception e) {
									e.printStackTrace();
								}
								return orderItemsList;
							}

							
							public int update(int id, int quantity) {
								try {
									pstmt=con.prepareStatement(UPDATE);
									pstmt.setInt(1,quantity);
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










