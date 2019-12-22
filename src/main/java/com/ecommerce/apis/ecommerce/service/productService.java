package com.ecommerce.apis.ecommerce.service;

import com.ecommerce.apis.ecommerce.entities.product;

import java.util.List;


public interface productService {


    List<product> getProducts();

    product getProduct(long id);

    product saveProduct(product pro);

    void deleteProduct(long id);

    void loadProduct(List<product> pro);


}