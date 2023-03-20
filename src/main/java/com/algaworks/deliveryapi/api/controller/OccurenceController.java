package com.algaworks.deliveryapi.api.controller;

import com.algaworks.deliveryapi.api.model.OccurenceModel;
import com.algaworks.deliveryapi.api.model.input.OccurenceInput;
import com.algaworks.deliveryapi.api.assembler.OccurenceAssembler;
import com.algaworks.deliveryapi.domain.model.Delivery;
import com.algaworks.deliveryapi.domain.model.Occurence;
import com.algaworks.deliveryapi.domain.service.RegisterOccurenceService;
import com.algaworks.deliveryapi.domain.service.SearchDeliveryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/delivery/{deliveryId}/occurences")
public class OccurenceController {

    private RegisterOccurenceService registerOccurenceService;
    private OccurenceAssembler occurenceAssembler;
    private SearchDeliveryService searchDeliveryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OccurenceModel register(@PathVariable Long deliveryId, @Valid @RequestBody OccurenceInput occurenceInput) {
        Occurence occurence = registerOccurenceService.registerOccurence(deliveryId, occurenceInput.getDescription());

        return occurenceAssembler.toModel(occurence);
    }

    @GetMapping
    public List<OccurenceModel> listAll(@PathVariable Long deliveryId) {
        Delivery delivery = searchDeliveryService.search(deliveryId);
        return occurenceAssembler.toCollectionModel(delivery.getOccurences());
    }
}
