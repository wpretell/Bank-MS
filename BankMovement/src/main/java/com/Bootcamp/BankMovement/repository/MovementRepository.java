package com.Bootcamp.BankMovement.repository;


import com.Bootcamp.BankMovement.domain.Movement;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MovementRepository extends MongoRepository<Movement, String> {
    List<Movement> findAllByClientProductId(String clientId);
}
