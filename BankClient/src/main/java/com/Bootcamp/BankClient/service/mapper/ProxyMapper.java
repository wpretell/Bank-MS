package com.Bootcamp.BankClient.service.mapper;

import java.util.List;

import com.Bootcamp.BankClient.domain.Proxy;
import com.Bootcamp.BankClient.web.model.ProxyModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface ProxyMapper {

    Proxy proxyModelToProxy (ProxyModel model);

    ProxyModel proxyToProxyModel (Proxy product);

    List<ProxyModel> proxyToProxyModels(List<Proxy> proxies);

    @Mapping(target = "proxyId", ignore = true)
    void update(@MappingTarget Proxy entity, ProxyModel updateEntity);

}
