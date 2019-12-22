package com.ecommerce.apis.ecommerce.Controllers.proController;


import com.ecommerce.apis.ecommerce.entities.product;
import com.ecommerce.apis.ecommerce.service.productServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class productController {
    @Autowired
    private productServiceImpl productService;
    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void create(@RequestBody List<product> pro)
    {
        productService.loadProduct(pro);
    }

    @GetMapping
    public List<product> index() {
        List<product> productList = productService.getProducts();
        return productList;
    }
    @GetMapping("/{id}")
    public product view(@PathVariable("id") long id)
    {
        product p = productService.getProduct(id);
        return p;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")long id) {

        productService.deleteProduct(id);
    }









}
