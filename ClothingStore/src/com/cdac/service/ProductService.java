package com.cdac.service;

import java.util.List;

import com.cdac.dto.Product;

public interface ProductService {
	void addProduct(Product product);
	void removeProduct(int ProductId);
	Product findProduct(int ProductId);
	void modifyProduct(Product product);
	List<Product> selectAll();
}
