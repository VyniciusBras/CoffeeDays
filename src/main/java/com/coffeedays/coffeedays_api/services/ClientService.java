package com.coffeedays.coffeedays_api.services;

import com.coffeedays.coffeedays_api.models.Client;
import com.coffeedays.coffeedays_api.port.ClientPersistencePort;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientService {
    private final ClientPersistencePort clientPersistencePort;

    public List<Client> getAllClients() {
        return clientPersistencePort.getAllClients();
    }

    public Client getClientById(Integer id) {
        return clientPersistencePort.getClientById(id);
    }

    public Map<String, String> validateProducts(List<Client> clients) {
        Map<String, String> errors = new HashMap<>();

        if (clients == null || clients.isEmpty()) {
            errors.put("error", "A lista de clientes esta vazia");
            return errors;
        }

        for (Client client : clients) {
            Integer clientId = client.getName();

            if (client.getName() == null) {
                errors.put("product", "ID do cliente é obrigatório");
                continue;
            }

        }

        return errors;
    }

    public Client createClient(Client client) {
        return clientPersistencePort.persist(client);
    }
}
