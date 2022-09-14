package com.Bootcamp.BankClient.web.controller;

import com.Bootcamp.BankClient.service.IProxyService;
import com.Bootcamp.BankClient.web.model.ProxyModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v2/proxy")
@Slf4j
public class ProxyController {

    private final IProxyService proxyService;

    @GetMapping()
    // @Operation(summary = "Get List of Proxies")
    public ResponseEntity<Object> getAll() throws Exception {
        List<ProxyModel> response = proxyService.findAll();
        log.info("getAll" + "OK");
        log.debug(response.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = { "{id}" }, produces = { "application/json" })
    public ResponseEntity<ProxyModel> getById(@PathVariable("id") String id) throws Exception{
        ProxyModel response = proxyService.findById(id);
        log.info("getById" + "OK");
        log.debug(id.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Object> create(@RequestBody ProxyModel proxyModel) throws Exception {
        ProxyModel response = proxyService.create(proxyModel);
        log.info("create" + "OK");
        log.debug(proxyModel.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(path = { "{id}" }, produces = { "application/json" })
    public void update(@PathVariable("id") String id, @RequestBody ProxyModel proxyModel) throws Exception {
        proxyService.update(id, proxyModel);
        log.info("update" + "OK");
        log.debug(id.toString() + "/" + proxyModel.toString());
    }

    @DeleteMapping({ "{id}" })
    public void deleteById(@PathVariable("id") String id) throws Exception {
        proxyService.deleteById(id);
        log.info("deleteById" + "OK");
        log.debug(id.toString());
    }
}
