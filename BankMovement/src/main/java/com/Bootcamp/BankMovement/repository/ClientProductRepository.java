package com.Bootcamp.BankMovement.repository;

import com.Bootcamp.BankMovement.domain.ClientProduct;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ClientProductRepository extends MongoRepository<ClientProduct, String> {
    List<ClientProduct> findAllByClientId(String clientId);
    List<ClientProduct> findAllByCodeProduct(String codeProduct);
}
