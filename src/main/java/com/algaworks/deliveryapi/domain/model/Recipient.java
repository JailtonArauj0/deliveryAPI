package com.algaworks.deliveryapi.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter @Getter
@Embeddable
public class Recipient {

    @NotBlank
    @Column(name = "recipient_name")
    private String name;

    @NotBlank
    @Column(name = "recipiente_street")
    private String street;

    @NotBlank
    @Column(name = "recipiente_number")
    private String number;

    @Column(name = "recipiente_complement")
    private String complement;

    @NotBlank
    @Column(name = "recipiente_district")
    private String district;

}
