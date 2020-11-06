package com.cdac.dao;

import java.util.List;

import com.cdac.dto.Product;

public interface ProductDao {
	void insertProduct(Product product);
	void deleteProduct(int ProductId);
	Product selectProduct(int ProductId);
	void updateProduct(Product product);
	List<Product> selectAll();

}
