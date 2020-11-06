package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.CartDao;
import com.cdac.dto.Cart;

@Service
public class CartServiceImple implements CartService {
	
	@Autowired
	private CartDao cartDao;

	@Override
	public void addCart(Cart cart) {
		cartDao.insertCart(cart);
		
	}

	@Override
	public Cart selectCart(int ProductId) {
		
		return cartDao.showCart(ProductId);
	}

	@Override
	public List<Cart> selectCartAll(int custId) {
		// TODO Auto-generated method stub
		return cartDao.showCartAll(custId);
	}

	@Override
	public boolean removeCart(int ProductId) {
		// TODO Auto-generated method stub
		return cartDao.deleteCart(ProductId);
	}

	@Override
	public boolean removeUserRecords(int custId) {
		// TODO Auto-generated method stub
		return cartDao.deleteUserRecords(custId);
	}
	
	

}