package com.Bootcamp.BankClient.repository;

import com.Bootcamp.BankClient.domain.ClientProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientProfileRepository extends MongoRepository<ClientProfile, String> {

}
