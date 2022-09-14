package com.Bootcamp.BankClient.repository;

import com.Bootcamp.BankClient.domain.Proxy;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProxyRepository extends MongoRepository<Proxy, String> {

    Optional<Proxy> findProxyByFullName(String fullName);

    List<Proxy> findProxyByClientId(String clientId);

}
