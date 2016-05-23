package com.tacademy.ecommerce.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tacademy.ecommerce.common.DataListRequestVO;
import com.tacademy.ecommerce.common.DataListResponseVO;
import com.tacademy.ecommerce.common.DataResponseVO;
import com.tacademy.ecommerce.common.ResponseVO;
import com.tacademy.ecommerce.domain.Order;
import com.tacademy.ecommerce.security.SecurityUtils;
import com.tacademy.ecommerce.service.OrderManager;
import com.tacademy.ecommerce.util.ParameterUtil;

@RestController
@RequestMapping("/order")
public class OrderController {

  @Autowired
  private OrderManager orderManager;

  @RequestMapping(method = RequestMethod.GET)
  public DataListResponseVO<Order> list(DataListRequestVO requestVO) {
    Long userId = SecurityUtils.getCurrentUser().getId();
    Page<Order> page = orderManager.getOrders(userId, requestVO.getPageable());
    return new DataListResponseVO<Order>(page);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public DataResponseVO<Order> detail(@PathVariable Long id) {
    Order order = orderManager.findOne(id);
    return new DataResponseVO<Order>(order);
  }

  // RequestBody 샘플
  @RequestMapping(method = RequestMethod.POST)
  public ResponseVO order(@RequestBody OrderRequestVO requestVO) {
    ParameterUtil.checkParameterEmpty(requestVO.getRecipientName(), requestVO.getPayMethod(), requestVO.getDeliveryAddress());
    orderManager.order(SecurityUtils.getCurrentUser(), requestVO);
    return ResponseVO.ok();
  }

  @RequestMapping(value = "/{id}/cancel", method = RequestMethod.POST)
  public ResponseVO orderCancel(@PathVariable Long id) {
    orderManager.cancel(SecurityUtils.getCurrentUser(), id);
    return ResponseVO.ok();
  }

}
