package com.Bootcamp.BankClient.repository;

import com.Bootcamp.BankClient.domain.Proxy;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProxyRepository extends MongoRepository<Proxy, String> {

}
