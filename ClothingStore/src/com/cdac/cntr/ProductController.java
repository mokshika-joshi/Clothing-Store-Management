package com.cdac.cntr;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cdac.dto.Admin;
import com.cdac.dto.Product;
import com.cdac.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/prep_Product_add_form.htm", method = RequestMethod.GET)
	public String prepProductAddForm(ModelMap map) {
		map.put("product", new Product());
		return "Product_add_form";
		
	}
	
	
	@RequestMapping(value = "/Product_add.htm", method = RequestMethod.POST)
	public String ProductAdd(Product product,ModelMap map) {
		
		productService.addProduct(product);
		map.put("product", product);
		return "Product_add_form";
		
	}
	@RequestMapping(value = "/Product_list.htm",method = RequestMethod.GET)
	public String allProduct(Product product,ModelMap map) {
		List<Product> li = productService.selectAll();
		map.put("proList", li);
		
		
		return "Product_list";
		
	}
	
	@RequestMapping(value = "/Product_delete.htm",method = RequestMethod.GET)
	public String productdelete(@RequestParam int productId,ModelMap map) {
		
		productService.removeProduct(productId);
		List<Product> li = productService.selectAll();
		map.put("proList", li);
		
		
		return "Product_list";
		
	}
	
	@RequestMapping(value = "/product_update_form.htm",method = RequestMethod.GET)
	public String productUpdateForm(@RequestParam int productId,ModelMap map) {
		
		Product pro = productService.findProduct(productId);
		map.put("product", pro);
		
		
		return "Product_update_form";
		
	}
	
	@RequestMapping(value = "/Product_update.htm", method = RequestMethod.POST)
	public String ProductUpdate(Product product,ModelMap map) {
		
		productService.modifyProduct(product);
		map.put("product", product);
		List<Product> li = productService.selectAll();
		map.put("proList", li);
		
		
		return "Product_list";
		
	}
}
