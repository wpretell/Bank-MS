package com.Bootcamp.BankMovement.service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;

import com.Bootcamp.BankMovement.service.mapper.ClientProductMapper;
import org.springframework.stereotype.Service;

import com.Bootcamp.BankMovement.domain.ClientProduct;
import com.Bootcamp.BankMovement.domain.Movement;
import com.Bootcamp.BankMovement.repository.ClientProductRepository;
import com.Bootcamp.BankMovement.repository.MovementRepository;
import com.Bootcamp.BankMovement.service.mapper.MovementMapper;
import com.Bootcamp.BankMovement.web.model.MovementModel;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovementService implements IMovementService {
	
	private final MovementRepository repository;
	private final MovementMapper mapper;
	private final ClientProductMapper clientProductMapper;
	private final ClientProductRepository clientProductRepository;

	@Override
	public List<MovementModel> findAll() throws Exception {
		List<Movement> movments = repository.findAll();
		return mapper.movementsToMovementModels(movments);
	}

	@Override
	public MovementModel findById(String id) throws Exception {
		Optional<Movement> movements = repository.findById(id);
		if (movements.isPresent()) {
			return mapper.movementToMovementModel(movements.get());
		}else {
			throw new Exception("No se encontraron Datos");
		}
		
	}

	@Override
	public MovementModel create(MovementModel movementModel) throws Exception {



		ClientProduct clientProduct = new ClientProduct();

		ClientProduct data =clientProductMapper.clientProductModelToClientProduct(movementModel.getClientProduct());

		//data.setProduct(movementMapper.productModelToProduct(data.getProductModel()));
         Movement x= mapper.movementModelToMovement(movementModel);
         x.setClientProduct(data);
		Movement movement = repository.save(x);


		return mapper.movementToMovementModel(movement);
				
	}

	@Override
	public void update(String id, MovementModel movementModel) throws Exception {
		Optional<Movement> movementOptional = repository.findById(id);
		if (movementOptional.isPresent()) {
			Movement movementToUpdate = movementOptional.get();
			mapper.update(movementToUpdate, movementModel);
			repository.save(movementToUpdate);
		}else {
			throw new Exception("N se encontraron datos");
		}
		
	}

	@Override
	public void deleteById(String id) throws Exception {
		repository.deleteById(id);
		
	}

}
