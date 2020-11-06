package com.cdac.service;


import java.util.List;

import com.cdac.dto.Cart;
import com.cdac.dto.Product;

public interface CartService {
	
	void addCart(Cart cart);
	Cart selectCart(int ProductId);
	List<Cart> selectCartAll(int custId);
	boolean removeCart(int ProductId);
	boolean removeUserRecords(int custId);
}