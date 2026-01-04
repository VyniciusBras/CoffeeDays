package com.coffeedays.coffeedays_api.port;

import com.coffeedays.coffeedays_api.models.Client;

import java.util.List;

public interface ClientPersistencePort {
    Client persist(Client client);
    List<Client> getAllClient();
    Client getClientById(Integer id);
}
