package com.cdac.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {
	
	@Id
	@GeneratedValue
	private int cartId;
	private int ProductId;
	private String ProductName;
	private String ProductCatagory;
	private float ProductPrice;
	private int ProductQuantity;
	private int custId;
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(int productId) {
		super();
		ProductId = productId;
	}
	public Cart(int productId, String productName, String productCatagory, float productPrice, int productQuantity,
			int custId) {
		super();
		ProductId = productId;
		ProductName = productName;
		ProductCatagory = productCatagory;
		ProductPrice = productPrice;
		ProductQuantity = productQuantity;
		this.custId = custId;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
		ProductId = productId;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getProductCatagory() {
		return ProductCatagory;
	}
	public void setProductCatagory(String productCatagory) {
		ProductCatagory = productCatagory;
	}
	public float getProductPrice() {
		return ProductPrice;
	}
	public void setProductPrice(float productPrice) {
		ProductPrice = productPrice;
	}
	public int getProductQuantity() {
		return ProductQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		ProductQuantity = productQuantity;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	
	
}
