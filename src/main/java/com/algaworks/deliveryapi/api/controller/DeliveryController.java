package com.algaworks.deliveryapi.api.controller;

import com.algaworks.deliveryapi.api.model.DeliveryOutput;
import com.algaworks.deliveryapi.api.model.input.DeliveryInput;
import com.algaworks.deliveryapi.api.assembler.DeliveryAssembler;
import com.algaworks.deliveryapi.domain.model.Delivery;
import com.algaworks.deliveryapi.domain.repository.DeliveryRepository;
import com.algaworks.deliveryapi.domain.service.EndDeliveryService;
import com.algaworks.deliveryapi.domain.service.RequestDeliveryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    private DeliveryRepository deliveryRepository;
    private RequestDeliveryService deliveryService;
    private DeliveryAssembler deliveryAssembler;
    private EndDeliveryService endDeliveryService;

    @PutMapping("/{deliveryId}/end")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void endDelivery(@PathVariable(name = "deliveryId") Long deliveryId) {
        endDeliveryService.endDelivery(deliveryId);
    }

    @PostMapping
    public ResponseEntity<DeliveryOutput> requestDelivery(@Valid @RequestBody DeliveryInput deliveryInput) {
        Delivery delivery = deliveryAssembler.toEntity(deliveryInput);

        Delivery deliveryReturn = deliveryService.requestDelivery(delivery);
        return new ResponseEntity<>(deliveryAssembler.toModel(deliveryReturn), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DeliveryOutput>> listAll() {
        List<Delivery> list = deliveryRepository.findAll();
        return new ResponseEntity<List<DeliveryOutput>>(deliveryAssembler.toCollectionModel(list), HttpStatus.OK);
    }

    @GetMapping("/{deliveryId}")
    public ResponseEntity<DeliveryOutput> findById(@PathVariable(name = "deliveryId") Long id) {
        return deliveryRepository.findById(id).map(entrega ->{return ResponseEntity.ok(deliveryAssembler.toModel(entrega));})
                .orElse(ResponseEntity.notFound().build());
    }
}
