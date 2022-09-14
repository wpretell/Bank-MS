package com.Bootcamp.BankMovement.service;


import com.Bootcamp.BankMovement.domain.Movement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.Bootcamp.BankMovement.domain.ClientProduct;
import com.Bootcamp.BankMovement.repository.ClientProductRepository;
import com.Bootcamp.BankMovement.service.mapper.ClientProductMapper;
import com.Bootcamp.BankMovement.web.model.ClientProductModel;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientProductService implements IClientProductService{

    private final ClientProductRepository clientProductRepository;
    private final ClientProductMapper clientProductMapper;




    @Override
    public List<ClientProductModel> findAll()  throws Exception {
        try {
            var clientProducts = clientProductRepository.findAll();
            return clientProductMapper.clientProductsToClientProductModels(clientProducts);
        }
        catch(Exception ex){
            throw new Exception("No se encontraron Datos");
        }

    }


    @Override
    public ClientProductModel findById(String id) throws Exception {
        Optional<ClientProduct> clientProduct = clientProductRepository.findById(id);
        if(clientProduct.isPresent()) return clientProductMapper.clientProductToClientProductModel(clientProduct.get());
        else throw new Exception("No se encontraron datos");
    }


    @Override
    public ClientProductModel create(ClientProductModel clientProductModel)  throws Exception{


        Boolean action=false;
        String message ="";
        try{
            ClientProduct clientProduct = new ClientProduct();
            if (clientProductModel.getClientType().equals("Personal")) {
                //Validamos que no tenga el tipo de producto repetido para registrar
                if(clientProductModel.getCodeProduct().equals("0001")
                        || clientProductModel.getCodeProduct().equals("0002")
                        || clientProductModel.getCodeProduct().equals("0003") )
                {
                    List<ClientProduct>  clientProducts= clientProductRepository.findAllByClientId(clientProductModel.getClientId());
                    Optional<ClientProduct> optional = clientProducts.stream()
                            .filter(x -> clientProductModel.getCodeProduct().equals(x.getCodeProduct()))
                            .findFirst();
                    if(optional.isEmpty()){
                        clientProduct = clientProductRepository.save(clientProductMapper.clientProductModelToClientProduct(clientProductModel));
                        action=true;
                    }
                    else{
                        message="No se puedo registrar, el cliente ya cuenta con este producto.";
                    }
                }
            }
            if (clientProductModel.getClientType().equals("VIP")) {

                if(clientProductModel.getCodeProduct().equals("0001"))
                {
                    List<ClientProduct>  clientProducts= clientProductRepository.findAllByClientId(clientProductModel.getClientId());
                    Optional<ClientProduct> optional = clientProducts.stream()
                            .filter(x -> clientProductModel.getCodeProduct().equals(x.getCodeProduct()))
                            .findFirst();


                    if(optional.isEmpty()){
                        clientProduct = clientProductRepository.save(clientProductMapper.clientProductModelToClientProduct(clientProductModel));
                        action=true;
                    }
                    else{
                        message="No se puedo registrar, el cliente ya cuenta con este producto.";
                    }
                }
                if(clientProductModel.getCodeProduct().equals("0005"))
                {
                    List<ClientProduct>  clientProducts= clientProductRepository.findAllByClientId(clientProductModel.getClientId());
                    Optional<ClientProduct> optional = clientProducts.stream()
                            .filter(x -> clientProductModel.getCodeProduct().equals(x.getCodeProduct()))
                            .findFirst();


                    if(optional.isEmpty()){
                        Optional<ClientProduct> optionalClientProd = clientProducts.stream()
                                .filter(x -> clientProductModel.getCodeProduct().equals("0001"))
                                .findFirst();


                        if(optionalClientProd.isEmpty()) {

                            ClientProduct info=   optionalClientProd.get();
                            if(info.getBalance().compareTo(BigDecimal.ZERO) == 0){
                                message="No se puedo registrar, el cliente no cuenta con Cuenta de ahorros no tiene saldo.";
                            }
                            else{
                                clientProduct = clientProductRepository.save(clientProductMapper.clientProductModelToClientProduct(clientProductModel));
                                action=true;
                            }

                        }
                        else{
                            message="No se puedo registrar, el cliente no cuenta con Cuenta de ahorros.";
                        }


                    }
                    else{
                        message="No se puedo registrar, el cliente ya cuenta con este producto.";
                    }
                }
                else{
                    message="No se puedo registrar, el cliente no puede tener el producto.";
                }

            }
            if (clientProductModel.getClientType().equals("Business")) {

                return clientProductModel;
            }
            if (clientProductModel.getClientType().equals("PYME")) {
                if(clientProductModel.getCodeProduct().equals("0002"))
                {
                    List<ClientProduct>  clientProducts= clientProductRepository.findAllByClientId(clientProductModel.getClientId());
                    Optional<ClientProduct> optional = clientProducts.stream()
                            .filter(x -> clientProductModel.getCodeProduct().equals(x.getCodeProduct()))
                            .findFirst();
                    if(optional.isEmpty()){
                        clientProduct = clientProductRepository.save(clientProductMapper.clientProductModelToClientProduct(clientProductModel));
                        action=true;
                    }
                    else{
                        message="No se puedo registrar, el cliente ya cuenta con este producto.";
                    }
                }
            }

            if(action)
                return clientProductMapper.clientProductToClientProductModel(clientProduct);
            else{

                throw new Exception("No se puedo registrar, el cliente ya cuenta con este producto.");

            }
        }
        catch(Exception e){
            throw new Exception("No se puedo registrar");
        }

    }

    @Override
    public void update(String id, ClientProductModel clientProductModel)  throws Exception {
        Optional<ClientProduct> eventOptional = clientProductRepository.findById(id);

        if(eventOptional.isPresent()) {
            ClientProduct clientProductToUpdate = eventOptional.get();
            clientProductMapper.update(clientProductToUpdate, clientProductModel);
            clientProductRepository.save(clientProductToUpdate);
        }
        else throw new Exception("No se encontraron datos");
    }

    @Override
    public void deleteById(String id)  throws Exception {
        clientProductRepository.deleteById(id);
    }
}
