package com.Bootcamp.BankProduct.domain;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.v3.oas.annotations.servers.Server;
import lombok.Getter;
import lombok.Setter;

@Document(collection = "Product")
@Getter
@Setter
public class Product {
	
	
    @Id
    private String id;
    
    private String codeProduct;

    private String type;

    private String description;

}
