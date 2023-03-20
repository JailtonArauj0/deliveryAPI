package com.algaworks.deliveryapi.domain.service;

import com.algaworks.deliveryapi.domain.exception.CustomException;
import com.algaworks.deliveryapi.domain.model.Client;
import com.algaworks.deliveryapi.domain.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class ClientService {

    private ClientRepository clientRepository;

    public Client findClient(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new CustomException("Usuário não encontrado"));
    }

    @Transactional
    public Client save(Client client) {
//        boolean emailExists = clientRepository.findByEmail(client.getEmail()).isPresent();
        return clientRepository.save(client);
    }

    @Transactional
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

}
