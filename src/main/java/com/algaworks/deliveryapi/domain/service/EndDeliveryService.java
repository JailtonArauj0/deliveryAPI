package com.algaworks.deliveryapi.domain.service;

import com.algaworks.deliveryapi.domain.model.Delivery;
import com.algaworks.deliveryapi.domain.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class EndDeliveryService {

    private DeliveryRepository deliveryRepository;
    private SearchDeliveryService searchDeliveryService;

    @Transactional
    public void endDelivery(Long deliveryId) {
        Delivery delivery = searchDeliveryService.search(deliveryId);
        delivery.end();
        deliveryRepository.save(delivery);
    }
}
