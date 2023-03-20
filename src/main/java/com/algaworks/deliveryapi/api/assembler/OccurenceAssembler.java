package com.algaworks.deliveryapi.api.assembler;

import com.algaworks.deliveryapi.api.model.OccurenceModel;
import com.algaworks.deliveryapi.api.model.input.OccurenceInput;
import com.algaworks.deliveryapi.domain.model.Occurence;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class OccurenceAssembler {

    private ModelMapper modelMapper;

    public OccurenceModel toModel(Occurence occurence) {
        return modelMapper.map(occurence, OccurenceModel.class);
    }

    public List<OccurenceModel> toCollectionModel(List<Occurence> occurences) {
        return occurences.stream().map(this::toModel).collect(Collectors.toList());
    }
}
