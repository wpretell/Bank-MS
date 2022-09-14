package com.Bootcamp.BankMovement.domain;

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
@Document(collection = "movement")
public class Movement {
    @Id
    private String id;

    private Date dateMovement;

    private String type;

    private BigDecimal amount;

    private String clientProductId;

}
