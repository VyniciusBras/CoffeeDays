package com.coffeedays.coffeedays_api.controllers;

import com.coffeedays.coffeedays_api.dto.CreateClientDto;
import com.coffeedays.coffeedays_api.models.Client;
import com.coffeedays.coffeedays_api.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public record ClientController(ClientService clientService) {
    @GetMapping
    public ResponseEntity<List<Client>> getAllClient() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @PostMapping
    public ResponseEntity<Client> createProduct(@RequestBody CreateClientDto dto) {

        Client client = new Client(
                null,
                dto.getName(),
                dto.getDocument(),
                dto.getEmail()
        );

        Client createdClient = clientService.createClient(client);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdClient);
    }
}
