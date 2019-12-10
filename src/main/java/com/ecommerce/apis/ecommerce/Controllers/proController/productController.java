package com.ecommerce.apis.ecommerce.Controllers.proController;


import com.ecommerce.apis.ecommerce.entities.product;
import com.ecommerce.apis.ecommerce.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class productController {
    @Autowired
    private productService productService;
    @PostMapping
    public product create( @RequestBody product pro)
    {
      return productService.saveProduct(pro);
    }

    @GetMapping
    public List<product> index()
    {
        List<product> productList = productService.getProducts();
        return productList;
    }
    @GetMapping("/{id}")
    public product view(@PathVariable("id") long id)
    {
        product p = productService.getProduct(id);
        return p;
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")long id)
    {

        productService.deleteProduct(id);
    }









}
