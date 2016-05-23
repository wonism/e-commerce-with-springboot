package com.tacademy.ecommerce.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.tacademy.ecommerce.common.ResponseVO;
import com.tacademy.ecommerce.domain.Product;
import com.tacademy.ecommerce.service.ProductManager;
import com.tacademy.ecommerce.util.FileUtil;

@Controller("adminProductController")
@RequestMapping("/admin/product")
@SessionAttributes("product")
public class ProductController {

  @Autowired
  private ProductManager productManager;

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public String list(Model model, Pageable pageable) {

    Page<Product> page = productManager.findProducts(pageable);
    model.addAttribute("page", page);
    return "product/list";
  }

  @RequestMapping(value = "/create", method = RequestMethod.GET)
  public String createform(Model model) {
    Product product = new Product();
    model.addAttribute("product", product);
    return "product/form";
  }

  @RequestMapping(value = "/view", method = RequestMethod.GET)
  public String view(@RequestParam Long id, Model model) {
    Product product = productManager.findOne(id);
    model.addAttribute("product", product);
    return "product/form";
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  @ResponseBody
  public ResponseVO save(@ModelAttribute Product product, @RequestParam("imageFile") MultipartFile imageFile,
      SessionStatus sessionStatus) {

    product = productManager.save(product);

    // Image Upload
    if (imageFile != null && !imageFile.isEmpty()) {
      FileUtil.upload(imageFile, product.getImageUploadPath());
      product.setImageFileName(imageFile.getOriginalFilename());
      productManager.save(product);
    }
    sessionStatus.setComplete();
    return ResponseVO.ok();
  }

  @RequestMapping(value = "/delete", method = RequestMethod.POST)
  @ResponseBody
  public ResponseVO delete(@RequestParam Long id) {
    productManager.delete(id);
    return ResponseVO.ok();
  }

}
