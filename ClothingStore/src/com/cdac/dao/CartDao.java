package com.cdac.dao;


import java.util.List;

import com.cdac.dto.Cart;


public interface CartDao {
	
	void insertCart(Cart cart);
	Cart showCart(int ProductId);
	List<Cart> showCartAll(int custId);
	boolean deleteCart(int ProductId);
	boolean deleteUserRecords(int custId);

}