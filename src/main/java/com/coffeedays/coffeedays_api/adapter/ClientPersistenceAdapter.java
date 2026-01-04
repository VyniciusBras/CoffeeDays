package com.coffeedays.coffeedays_api.adapter;


import com.coffeedays.coffeedays_api.entities.ClientEntity;
import com.coffeedays.coffeedays_api.mapper.ClientMapper;
import com.coffeedays.coffeedays_api.models.Client;
import com.coffeedays.coffeedays_api.port.ClientPersistencePort;
import com.coffeedays.coffeedays_api.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.StreamSupport;

@Component
@RequiredArgsConstructor
public class ClientPersistenceAdapter implements ClientPersistencePort {

    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;

    @Override
    public Client persist(Client client) {
        ClientEntity productEntity = clientMapper.toEntity(client);
        clientRepository.save(clientEntity);
        return client;
    }
    public List<Client> getAllClient() {
        List<ClintEntity> clients = StreamSupport.stream(clientRepository.findAll().spliterator(), false).toList();
        return clientMapper.toClient(clients);
    }

    @Override
    public Client getClientById(Integer id) {
        ClientEntity clientEntity = clientRepository.findById(id).orElse(null);
        return clientMapper.toClient(clientEntity);
    }
}
