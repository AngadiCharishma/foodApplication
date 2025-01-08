package com.foodapp.dao.interfaces;

import java.util.List;

import com.tap.model.Product;

public interface ProductDAO {
    
	List<Product> fetchAll();
}
