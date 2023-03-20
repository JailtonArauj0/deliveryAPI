package com.algaworks.deliveryapi.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class OccurenceInput {

    @NotBlank
    private String description;
}
