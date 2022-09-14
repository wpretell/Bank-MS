package com.Bootcamp.BankClient.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Bootcamp.BankClient.domain.Client;
import com.Bootcamp.BankClient.repository.ClientRepository;
import com.Bootcamp.BankClient.service.mapper.ClientMapper;
import com.Bootcamp.BankClient.web.model.ClientModel;
import com.mongodb.connection.Stream;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService implements IClientService {
	private final ClientRepository clientRepository;
	private final ClientMapper clientMapper;

	@Override
	public List<ClientModel> findAll() throws Exception {
		List<Client> clients = clientRepository.findAll();
		return clientMapper.clientsToClientModels(clients);
	}


	@Override
	public ClientModel findById(String id) throws Exception {
		Optional<Client> client = clientRepository.findById(id);
		if (client.isPresent())
			return clientMapper.clientToClientModel(client.get());
		else
			throw new Exception("No se encontraron datos");
	}

	@Override
	public ClientModel create(ClientModel clientModel) throws Exception {

		Client client = clientRepository.save(clientMapper.clientModelToClient(clientModel));
		return clientMapper.clientToClientModel(client);
	}

	@Override
	public void update(String id, ClientModel ClientModel) throws Exception {
		Optional<Client> clientOptional = clientRepository.findById(id);

		if (clientOptional.isPresent()) {
			Client clientToUpdate = clientOptional.get();
			clientMapper.update(clientToUpdate, ClientModel);
			clientRepository.save(clientToUpdate);
		} else
			throw new Exception("No se encontraron datos");
	}

	@Override
	public void deleteById(String id) throws Exception {
		clientRepository.deleteById(id);
	}
}
