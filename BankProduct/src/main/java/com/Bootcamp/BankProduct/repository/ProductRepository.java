package com.Bootcamp.BankProduct.repository;


import org.springframework.data.mongodb.repository.MongoRepository;


import com.Bootcamp.BankProduct.domain.Product;


import java.util.List;
import java.util.Optional;


public interface ProductRepository extends MongoRepository<Product, String> {

     Optional<Product> findProductByDescription(String description);
     Optional<Product>findProductByCodeProduct(String codeProduct);
}
