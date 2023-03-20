package com.algaworks.deliveryapi.domain.service;

import com.algaworks.deliveryapi.domain.exception.CustomException;
import com.algaworks.deliveryapi.domain.exception.EntityNotFoundException;
import com.algaworks.deliveryapi.domain.model.Delivery;
import com.algaworks.deliveryapi.domain.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SearchDeliveryService {

    private DeliveryRepository deliveryRepository;

    public Delivery search(Long deliveryId) {
        return deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new EntityNotFoundException("Entrega não encontrada"));
    }
}
