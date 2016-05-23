package com.tacademy.ecommerce.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tacademy.ecommerce.api.OrderRequestVO;
import com.tacademy.ecommerce.common.ResponseVO;
import com.tacademy.ecommerce.domain.OrderProduct;
import com.tacademy.ecommerce.security.SecurityUtils;
import com.tacademy.ecommerce.service.OrderManager;
import com.tacademy.ecommerce.util.ParameterUtil;

@Controller("userOrderController")
@RequestMapping("/user/order")
public class UserOrderController {

	
	  @Autowired
	  private OrderManager orderManager;

	  
	  
	  @RequestMapping(value = "/add", method = RequestMethod.POST)
	  @ResponseBody
	  public ResponseVO addOrder(@RequestBody OrderRequestVO requestVO) {
	    ParameterUtil.checkParameterEmpty(requestVO.getRecipientName(), requestVO.getPayMethod(), requestVO.getDeliveryAddress());
	    orderManager.order(SecurityUtils.getCurrentUser(), requestVO);
	    return ResponseVO.ok();
	  }
	  
	  @RequestMapping(value = "/list", method = RequestMethod.GET)
	  public String list(Model model, Pageable pageable) {
		  
		  
		Long userId = SecurityUtils.getCurrentUser().getId();
	    Page<OrderProduct> page = orderManager.getOrderProducts(userId, pageable);
	    model.addAttribute("page", page);
	    
	    
	    return "user/product/orderlist";
	  }

	  

}
