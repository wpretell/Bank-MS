package com.Bootcamp.BankMovement.domain;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "clientProduct")
public class ClientProduct {
    @Id
    private String id;

    @Column(unique=true)
    private String accountNumber;

    private BigDecimal balance;

    private Date openDate;

    private Date closeDate;


    private String clientId;

    private String productId;

    private String codeProduct;

}
