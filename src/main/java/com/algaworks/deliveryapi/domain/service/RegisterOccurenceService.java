package com.algaworks.deliveryapi.domain.service;

import com.algaworks.deliveryapi.domain.model.Delivery;
import com.algaworks.deliveryapi.domain.model.Occurence;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegisterOccurenceService {

    private SearchDeliveryService searchDeliveryService;

    @Transactional
    public Occurence registerOccurence(Long deliveryId, String description) {
        Delivery delivery = searchDeliveryService.search(deliveryId);

        return delivery.addOccurence(description);
    }
}
