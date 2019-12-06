package com.ecommerce.apis.ecommerce.service;

import com.ecommerce.apis.ecommerce.entities.product;
import com.ecommerce.apis.ecommerce.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class productService {
    @Autowired
    productRepository proRepo;

    public List<product> getProducts()
    {
        return proRepo.findAll();
    }
    public product getProduct(long id)
    {
        return proRepo.getOne(id);
    }
    public product saveProduct(product pro){
        return proRepo.save(pro);
    }

    public void deleteProduct(long id){
        proRepo.deleteById(id);
    }
//   public product updateProduct(product product, long id)
//    {
//        return proRepo.findById(id).map(
//                pro-> {pro.setName(product.getName());
//                    pro.setPath(product.getPath());
//                    pro.setPrice(product.getPrice());
//                    return proRepo.save(pro);
//                }
//        ).orElseGet(()-> {
//            product.setId(id);
//            return proRepo.save(product);});
//    }

}