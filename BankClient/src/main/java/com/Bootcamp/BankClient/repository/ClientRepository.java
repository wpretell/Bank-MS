package com.Bootcamp.BankClient.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Bootcamp.BankClient.domain.Client;

public interface ClientRepository  extends MongoRepository<Client, String> {

	List<Client> findByDocumentNumber(String documentNumber);

}
