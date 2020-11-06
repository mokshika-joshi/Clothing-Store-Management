package com.cdac.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {
	@Id
	@GeneratedValue
	private int ProductId;
	private String ProductName;
	private String ProductCategory;
	private float ProductPrice;
	private String ProductDescription;
	private int ProductQuantity;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Product(int productId) {
		super();
		ProductId = productId;
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
	public String getProductCategory() {
		return ProductCategory;
	}
	public void setProductCategory(String productCategory) {
		ProductCategory = productCategory;
	}
	public float getProductPrice() {
		return ProductPrice;
	}
	public void setProductPrice(float productPrice) {
		ProductPrice = productPrice;
	}
	public String getProductDescription() {
		return ProductDescription;
	}
	public void setProductDescription(String productDescription) {
		ProductDescription = productDescription;
	}
	public int getProductQuantity() {
		return ProductQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		ProductQuantity = productQuantity;
	}


	@Override
	public String toString() {
		return "Product [ProductId=" + ProductId + ", ProductName=" + ProductName + ", ProductCategory="
				+ ProductCategory + ", ProductPrice=" + ProductPrice + ", ProductDescription=" + ProductDescription
				+ ", ProductQuantity=" + ProductQuantity + "]";
	}
	 
}
