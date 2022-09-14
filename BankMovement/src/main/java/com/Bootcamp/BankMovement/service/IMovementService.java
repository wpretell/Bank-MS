package com.Bootcamp.BankMovement.service;

import java.util.List;

import com.Bootcamp.BankMovement.web.model.MovementModel;



public interface IMovementService {
	List<MovementModel> findAll() throws Exception;

	MovementModel findById(String id) throws Exception;
	
	MovementModel create(MovementModel movementModel) throws Exception;

	void update(String id, MovementModel movementModel) throws Exception;

	void deleteById(String id) throws Exception;
}
