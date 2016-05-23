package com.tacademy.ecommerce.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tacademy.ecommerce.common.DataListRequestVO;
import com.tacademy.ecommerce.common.DataListResponseVO;
import com.tacademy.ecommerce.common.DataResponseVO;
import com.tacademy.ecommerce.domain.Product;
import com.tacademy.ecommerce.service.ProductManager;

@RestController
@RequestMapping("/product")
public class ProductController {

  @Autowired
  private ProductManager productManager;

  @RequestMapping(method = RequestMethod.GET)
  public DataListResponseVO<Product> list(DataListRequestVO requestVO) {

    Page<Product> page = productManager.findProducts(requestVO.getPageable());
    return new DataListResponseVO<Product>(page);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public DataResponseVO<Product> detail(@PathVariable Long id) {

    Product product = productManager.findOne(id);
    return new DataResponseVO<Product>(product);
  }

}
