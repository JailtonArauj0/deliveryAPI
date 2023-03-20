package com.algaworks.deliveryapi.api.assembler;

import com.algaworks.deliveryapi.api.model.DeliveryOutput;
import com.algaworks.deliveryapi.api.model.input.DeliveryInput;
import com.algaworks.deliveryapi.domain.model.Delivery;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class DeliveryAssembler {

    private ModelMapper modelMapper;

    public DeliveryOutput toModel(Delivery delivery) {
        return modelMapper.map(delivery, DeliveryOutput.class);
    }

    public List<DeliveryOutput> toCollectionModel(List<Delivery> deliveryList) {
        return deliveryList.stream().map(this::toModel).collect(Collectors.toList());
    }

    public Delivery toEntity(DeliveryInput deliveryInput) {
        return modelMapper.map(deliveryInput, Delivery.class);
    }
}
