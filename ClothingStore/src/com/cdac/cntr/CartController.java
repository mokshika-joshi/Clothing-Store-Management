package com.cdac.cntr;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdac.dto.Cart;
import com.cdac.dto.Customer;
import com.cdac.dto.Product;
import com.cdac.service.CartService;
import com.cdac.service.ProductService;

@Controller
public class CartController {
	@Autowired
	private CartService cartService;
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/addToCart.htm", method = RequestMethod.POST)
	public String addToCart(Cart cart, ModelMap map, HttpSession session) {
		
		System.out.println("hi");
		if(((Customer)session.getAttribute("customer")) == null)
			return "home";
		
		
		System.out.println(cart.getProductId()+" "+cart.getProductQuantity());
		cart.setCustId(((Customer)session.getAttribute("customer")).getCustId());
		Product product = productService.findProduct(cart.getProductId());
		cart.setProductPrice(product.getProductPrice() * cart.getProductQuantity());
		cart.setProductName(product.getProductName());
		cart.setProductCatagory(product.getProductCategory());
		cartService.addCart(cart);
		
		List<Product> li = productService.selectAll();
		map.put("itemList", li);
		return "User_list";
	}
	
	
	
	@RequestMapping(value = "/getCart.htm")
	public String getCart(ModelMap map, HttpSession session) {
		int custId = ((Customer)session.getAttribute("customer")).getCustId();
		List<Cart> itemsList = cartService.selectCartAll(custId);
		map.put("itemsList", itemsList);
		return "cart";
	}
	
	
	@RequestMapping(value = "/delItem.htm")
	public String deleteItemFromCart(@RequestParam int cartId, ModelMap map, HttpSession session) {
		int custId = ((Customer)session.getAttribute("customer")).getCustId();
		cartService.removeUserRecords(cartId);
		List<Cart> itemsList = cartService.selectCartAll(custId);
		map.put("itemsList", itemsList);
		return "cart";
	}


}
