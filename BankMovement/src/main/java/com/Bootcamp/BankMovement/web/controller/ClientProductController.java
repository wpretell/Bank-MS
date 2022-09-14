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

import com.Bootcamp.BankMovement.service.IClientProductService;
import com.Bootcamp.BankMovement.web.model.ClientProductModel;


@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/clientProduct")
@Slf4j
public class ClientProductController {

    @Autowired
    private final IClientProductService clientProductService;


    /**
     * Get list of clientProducts
     * @return
     * @throws Exception
     */
    @GetMapping()
    @Operation(summary = "Get list of clientProducts")
    public ResponseEntity<Object> getAll() throws Exception {
        List<ClientProductModel> response =  clientProductService.findAll();
        log.info("getAll" + "OK");
        log.debug(response.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Get clientProduct by id
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping(path = { "{id}" }, produces = { "application/json" })
    public ResponseEntity<ClientProductModel> getById(@PathVariable("id") String id) throws Exception{
        ClientProductModel response = clientProductService.findById(id);
        log.info("getById" + "OK");
        log.debug(id.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Create clientProduct
     * @param clientProductModel
     * @return
     * @throws Exception
     */
    @PostMapping(path = "/create")
    public ResponseEntity<Object> create(@RequestBody ClientProductModel clientProductModel) throws Exception {

        try{
            ClientProductModel response = clientProductService.create(clientProductModel);


            log.info("create" + "OK");
            log.debug(clientProductModel.toString());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){

            return new ResponseEntity<>("Error:"+e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    /**
     * Update clientProduct by id
     * @param id
     * @param clientProductModel
     * @throws Exception
     */
    @PutMapping(path = { "{id}" }, produces = { "application/json" })
    public void update(
            @PathVariable("id") String id,
            @RequestBody ClientProductModel clientProductModel) throws Exception {
        clientProductService.update(id, clientProductModel);
        log.info("update" + "OK");
        log.debug(id.toString()+ "/" + clientProductModel.toString());
    }

    /**
     * Delete clientProduct by id
     * @param id
     * @throws Exception
     * @author aangulom
     */
    @DeleteMapping({ "{id}" })
    public void deleteById(@PathVariable("id") String id) throws Exception {
        clientProductService.deleteById(id);
        log.info("deleteById" + "OK");
        log.debug(id.toString());
    }

}
