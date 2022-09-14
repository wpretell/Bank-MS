package com.Bootcamp.BankProduct.web;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Bootcamp.BankProduct.service.IProductService;
import com.Bootcamp.BankProduct.web.model.ProductModel;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/product")
@Slf4j
public class ProductController {
    @Autowired
    private final IProductService productService;

    @GetMapping()
   // @Operation(summary = "Get List of Products")
    public ResponseEntity<Object> getAll() throws Exception {
        List<ProductModel> response = productService.findAll();
        log.info("getAll" + "OK");
        log.debug(response.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = { "{id}" }, produces = { "application/json" })
    public ResponseEntity<ProductModel> getById(@PathVariable("id") String id) throws Exception{
        ProductModel response = productService.findById(id);
        log.info("getById" + "OK");
        log.debug(response.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @GetMapping(path = { "/codeProduct" }, produces = { "application/json" })
    public ResponseEntity<ProductModel> getByCodeProduct(@RequestParam String codeProduct) throws Exception{
        ProductModel response = productService.findProductByCodeProduct(codeProduct);
        log.info("getByCodeProduct" + "OK");
        log.debug(response.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = { "/" }, produces = { "application/json" })
    public ResponseEntity<ProductModel> getByDescription(@RequestParam String description) throws Exception{
        ProductModel response = productService.findProductByDescription(description);
        log.info("getByDescription" + "OK");
        log.debug(response.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Object> create(@RequestBody ProductModel productModel) throws Exception {
        ProductModel response = productService.create(productModel);
        log.info("create" + "OK");
        log.debug(response.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(path = { "{id}" }, produces = { "application/json" })
    public void update(@PathVariable("id") String id,  @RequestBody ProductModel productModel) throws Exception {
        productService.update(id, productModel);
        log.info("update" + "OK");
        log.debug(id.toString() + productModel.toString());
    }

    @DeleteMapping({ "{id}" })
    public void deleteById(@PathVariable("id") String id) throws Exception {
        productService.deleteById(id);
        log.info("deleteById" + "OK");
        log.debug(id.toString());
    }
}

