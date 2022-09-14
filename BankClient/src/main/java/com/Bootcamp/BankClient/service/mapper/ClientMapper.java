package com.Bootcamp.BankClient.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.Bootcamp.BankClient.domain.Client;
import com.Bootcamp.BankClient.web.model.ClientModel;

@Mapper(componentModel = "spring")
public interface ClientMapper {
	Client clientModelToClient(ClientModel model);
	ClientModel clientToClientModel(Client client);
	List<ClientModel> clientsToClientModels(List<Client> clients);

	@Mapping(target = "id", ignore = true)
	void update(@MappingTarget Client entity, ClientModel updateEntity);

}
