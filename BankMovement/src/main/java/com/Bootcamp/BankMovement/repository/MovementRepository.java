package com.Bootcamp.BankMovement.repository;


import com.Bootcamp.BankMovement.domain.Movement;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovementRepository extends MongoRepository<Movement, String> {

}
