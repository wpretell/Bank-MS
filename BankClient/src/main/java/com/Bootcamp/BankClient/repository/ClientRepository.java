package com.Bootcamp.BankClient.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Bootcamp.BankClient.domain.Client;

import java.util.Optional;

public interface ClientRepository  extends MongoRepository<Client, String> {



}
