package com.algaworks.deliveryapi.api.model.input;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;

@Getter @Setter
public class RecipientInput {

    @NotBlank
    private String name;

    @NotBlank
    private String street;

    @NotBlank
    private String number;

    private String complement;

    @NotBlank
    private String district;
}
