package com.tacademy.ecommerce.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tacademy.ecommerce.common.DataListRequestVO;
import com.tacademy.ecommerce.common.DataListResponseVO;
import com.tacademy.ecommerce.common.ResponseVO;
import com.tacademy.ecommerce.domain.CartProduct;
import com.tacademy.ecommerce.security.SecurityUtils;
import com.tacademy.ecommerce.service.CartManager;

@RestController
@RequestMapping("/cart")
public class CartController {

  @Autowired
  private CartManager cartManager;

  @RequestMapping(method = RequestMethod.GET)
  public DataListResponseVO<CartProduct> list(DataListRequestVO requestVO) {
    Long userId = SecurityUtils.getCurrentUser().getId();
    Page<CartProduct> page = cartManager.getCartProducts(userId, requestVO.getPageable());
    return new DataListResponseVO<CartProduct>(page);
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseVO addProduct(@RequestParam(value = "id") Long productId, @RequestParam Integer buyCount) {
    Long userId = SecurityUtils.getCurrentUser().getId();
    cartManager.addProduct(userId, productId, buyCount);
    return ResponseVO.ok();
  }

  @RequestMapping(value = "/product/{id}/delete", method = RequestMethod.POST)
  public ResponseVO deleteProduct(@PathVariable Long id) {
    Long userId = SecurityUtils.getCurrentUser().getId();
    cartManager.deleteProduct(userId, id);
    return ResponseVO.ok();
  }

}
