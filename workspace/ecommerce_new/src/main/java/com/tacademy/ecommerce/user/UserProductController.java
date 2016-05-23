package com.tacademy.ecommerce.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tacademy.ecommerce.domain.Product;
import com.tacademy.ecommerce.domain.User;
import com.tacademy.ecommerce.security.SecurityUtils;
import com.tacademy.ecommerce.service.ProductManager;

@Controller("userProductController")
@RequestMapping("/user/product")
public class UserProductController {

	  @Autowired
	  private ProductManager productManager;

	  @RequestMapping(value = "/list", method = RequestMethod.GET)
	  public String list(Model model, Pageable pageable) {

	    Page<Product> page = productManager.findProducts(pageable);
	    model.addAttribute("page", page);
	    return "user/product/list";
	  }
	  
	  @RequestMapping(value = "/view", method = RequestMethod.GET)
	  public String view(@RequestParam Long id, Model model) {
		  
		User user =  SecurityUtils.getCurrentUser();  
		  
	    Product product = productManager.findOne(id);
	    model.addAttribute("product", product);
	    model.addAttribute("user", user);
	    return "user/product/view";
	  }


}
