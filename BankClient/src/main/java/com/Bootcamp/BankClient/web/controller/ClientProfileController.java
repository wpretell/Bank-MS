package com.Bootcamp.BankClient.web.controller;

import com.Bootcamp.BankClient.service.IClientProfileService;
import com.Bootcamp.BankClient.web.model.ClientProfileModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v2/clientProfile")
@Slf4j
public class ClientProfileController {

    @Autowired
    private final IClientProfileService clientProfileService;

    @GetMapping()
    // @Operation(summary = "Get List of clientProfiles")
    public ResponseEntity<Object> getAll() throws Exception {
        List<ClientProfileModel> response = clientProfileService.findAll();
        log.info("getAll" + "OK");
        log.debug(response.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = { "{id}" }, produces = { "application/json" })
    public ResponseEntity<ClientProfileModel> getById(@PathVariable("id") String id) throws Exception{
        ClientProfileModel response = clientProfileService.findById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Object> create(@RequestBody ClientProfileModel clientProfileModel) throws Exception {
        ClientProfileModel response = clientProfileService.create(clientProfileModel);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(path = { "{id}" }, produces = { "application/json" })
    public void update(@PathVariable("id") String id, @RequestBody ClientProfileModel clientProfileModel) throws Exception {
        clientProfileService.update(id, clientProfileModel);
    }

    @DeleteMapping({ "{id}" })
    public void deleteById(@PathVariable("id") String id) throws Exception {
        clientProfileService.deleteById(id);
    }

}
