package com.Bootcamp.BankMovement.web.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Bootcamp.BankMovement.service.IMovementService;
import com.Bootcamp.BankMovement.web.model.MovementModel;


@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/movement")
@Slf4j
public class MovementController {

	@Autowired
	private final IMovementService movementService;


	/**
	 * Get list of movements
	 * @return
	 * @throws Exception
	 */
	@GetMapping()
	@Operation(summary = "Get list of movements")
	public ResponseEntity<Object> getAll() throws Exception {
		List<MovementModel> response =  movementService.findAll();
		log.info("getAll" + "OK");
		log.debug(response.toString());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	/**
	 * Get Movement by id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping(path = { "{id}" })
	@Operation(summary = "Get list of movements")
	public  ResponseEntity<Object> findAllByClientProductId(@PathVariable("id") String id) throws Exception{
		List<MovementModel> response =  movementService.findAllByClientProductId(id);
		log.info("getAll" + "OK");
		log.debug(response.toString());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * Get Movement by id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping(path = { "{id}" }, produces = { "application/json" })
	public ResponseEntity<MovementModel> getById(@PathVariable("id") String id) throws Exception{
		MovementModel response = movementService.findById(id);
		log.info("getById" + "OK");
		log.debug(id.toString());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	/**
	 * Create Movement
	 * @param movementModel
	 * @return
	 * @throws Exception
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<Object> create(@RequestBody MovementModel movementModel) throws Exception {

		try{
			MovementModel response = movementService.create(movementModel);


			log.info("create" + "OK");
			log.debug(movementModel.toString());
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		catch (Exception e){

			return new ResponseEntity<>("Error:"+e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}


	/**
	 * Update Movement by id
	 * @param id
	 * @param movementModel
	 * @throws Exception
	 */
	@PutMapping(path = { "{id}" }, produces = { "application/json" })
	public void update(
			@PathVariable("id") String id,
			@RequestBody MovementModel movementModel) throws Exception {
		movementService.update(id, movementModel);
		log.info("update" + "OK");
		log.debug(id.toString()+ "/" + movementModel.toString());
	}

	/**
	 * Delete Movement by id
	 * @param id
	 * @throws Exception
	 * @author aangulom
	 */
	@DeleteMapping({ "{id}" })
	public void deleteById(@PathVariable("id") String id) throws Exception {
		movementService.deleteById(id);
		log.info("deleteById" + "OK");
		log.debug(id.toString());
	}

}
