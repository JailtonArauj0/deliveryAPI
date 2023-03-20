package com.algaworks.deliveryapi.api.controller;

import com.algaworks.deliveryapi.domain.model.Client;
import com.algaworks.deliveryapi.domain.repository.ClientRepository;
import com.algaworks.deliveryapi.domain.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/clients")
public class ClientController {

    private ClientRepository clientRepository;
    private ClientService clientService;

    @GetMapping
    private List<Client> clients() {
        return clientRepository.findAll();
    }

    @GetMapping("/{idclient}")
    private ResponseEntity<Client> findById(@PathVariable(name = "idclient") Long id) {
        Optional<Client> client = clientRepository.findById(id);

        if (client.isPresent()) {
            return new ResponseEntity<>(client.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    private ResponseEntity<Client> save(@Valid @RequestBody Client client) {
        Client clientSaved = clientService.save(client);
        return new ResponseEntity<>(clientSaved, HttpStatus.CREATED);
    }

    @PutMapping("/{idclient}")
    private ResponseEntity<Client> update(@Valid @RequestBody Client client, @PathVariable(name = "idclient") Long id) {
        Optional<Client> clientSearched = clientRepository.findById(id);

        if (clientSearched.isPresent()) {
            client.setId(id);
            Client clientSaved = clientService.save(client);
            return new ResponseEntity<>(clientSaved, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{idclient}")
    private ResponseEntity<Void> delete(@PathVariable(name = "idclient") Long id) {
        if (clientRepository.existsById(id)) {
            clientService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
