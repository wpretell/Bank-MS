package com.Bootcamp.BankClient.web.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProxyModel {

    private String proxyId;

    private String type;

    private String fullName;

    private String clientId;

}
