package com.ecommerce.apis.ecommerce.service;

import com.ecommerce.apis.ecommerce.entities.category;
import com.ecommerce.apis.ecommerce.entities.product;
import com.ecommerce.apis.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.apis.ecommerce.repository.categoryRepository;
import com.ecommerce.apis.ecommerce.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class productServiceImpl implements productService {
    @Autowired
    productRepository proRepo;
    @Autowired
    categoryRepository cateRepo;

    public List<product> getProducts() {
        return proRepo.findAll();
    }

    public product getProduct(long id) {
        return proRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("product not found", "productId:" + id, "ID", id));
    }

    public product saveProduct(product pro) {
        category cate = pro.getCategory();
        if (!cateRepo.existsByName(cate.getName())) {
            cate = cateRepo.save(cate);
        }
        pro.setCategory(cate);
        return proRepo.save(pro);
    }

    public void deleteProduct(long id) {
        proRepo.deleteById(id);
    }

    @Override
    public void loadProduct(List<product> pro) {
        pro.stream()
                .forEach(product -> saveProduct(product));
    }
}