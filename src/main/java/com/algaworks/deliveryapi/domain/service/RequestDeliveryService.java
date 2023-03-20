package com.algaworks.deliveryapi.domain.service;

import com.algaworks.deliveryapi.domain.model.Client;
import com.algaworks.deliveryapi.domain.model.Delivery;
import com.algaworks.deliveryapi.domain.model.DeliveryStatus;
import com.algaworks.deliveryapi.domain.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class RequestDeliveryService {

    private DeliveryRepository deliveryRepository;
    private ClientService clientService;

    @Transactional
    public Delivery requestDelivery(Delivery delivery) {
        Client client = clientService.findClient(delivery.getClient().getId());

        delivery.setClient(client);
        delivery.setStatus(DeliveryStatus.PENDENTE);
        delivery.setOrderDate(OffsetDateTime.now());
        return deliveryRepository.save(delivery);
    }
}
