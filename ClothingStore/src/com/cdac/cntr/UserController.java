package com.cdac.cntr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cdac.dto.Product;
import com.cdac.service.ProductService;
@Controller
public class UserController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/list.htm",method = RequestMethod.GET)
	public String allProduct(ModelMap map) {
		List<Product> li = productService.selectAll();
		map.put("itemList", li);
		
		
		return "User_list";
		
	}
}
