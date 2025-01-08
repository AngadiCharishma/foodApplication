package com.foodapp.dao.impl;



import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.dao.interfaces.ProductDAO;
import com.tap.model.Product;

public class ProductDaoImpl implements ProductDAO {

	private static final String URL = "jdbc:mysql://localhost:3306/jdbcnov";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String FETCH_ALL_QUERY="SELECT * from products";


	public List<Product> fetchAll() {
		List<Product> products = new ArrayList<Product>();


		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery(FETCH_ALL_QUERY);

			while (resultSet.next()) {
				products.add(new Product(resultSet.getInt("pid"),
			                  resultSet.getString("product_name"),
				              resultSet.getInt("product_price"),
				              resultSet.getInt("product_rating"),
			                  resultSet.getString("product_description")));

				
			}

		} 
		catch (Exception e) {
			e.printStackTrace();
		}

		return products;
	}
}

