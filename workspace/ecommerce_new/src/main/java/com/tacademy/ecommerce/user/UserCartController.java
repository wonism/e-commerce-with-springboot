package com.tacademy.ecommerce.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tacademy.ecommerce.common.DataListRequestVO;
import com.tacademy.ecommerce.common.DataListResponseVO;
import com.tacademy.ecommerce.common.ResponseVO;
import com.tacademy.ecommerce.domain.CartProduct;
import com.tacademy.ecommerce.domain.Product;
import com.tacademy.ecommerce.security.SecurityUtils;
import com.tacademy.ecommerce.service.CartManager;

@Controller("userCartController")
@RequestMapping("/user/cart")
public class UserCartController {

	  @Autowired
	  private CartManager cartManager;

	  @RequestMapping(value = "/add", method = RequestMethod.POST)
	  @ResponseBody
	  public ResponseVO addProduct(@RequestParam(value = "id") Long productId, @RequestParam(value="bcnt") Integer buyCount) {
		  
		  System.out.println("## 카트에 담앗다 : " + productId + " , buyCount : " + buyCount);
	    Long userId = SecurityUtils.getCurrentUser().getId();
	    cartManager.addProduct(userId, productId, buyCount);
	    return ResponseVO.ok();
	  }

	  

	  @RequestMapping(value = "/list", method = RequestMethod.GET)
	  public String list(Model model, Pageable pageable) {
		  
		  
		Long userId = SecurityUtils.getCurrentUser().getId();
	    Page<CartProduct> page = cartManager.getCartProducts(userId, pageable);
	    model.addAttribute("page", page);
	    
	    return "user/product/cartlist";
	  }
	  
}
