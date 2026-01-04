package com.coffeedays.coffeedays_api.mapper;

import com.coffeedays.coffeedays_api.entities.ClientEntity;
import com.coffeedays.coffeedays_api.models.Client;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientEntity toEntity(Client client);
    List<Client> toProduct(List<ClientEntity> clientEntity);
    Client toProduct(ClientEntity clientEntity);
}
