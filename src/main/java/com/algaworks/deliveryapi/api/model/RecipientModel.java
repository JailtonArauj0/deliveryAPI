package com.algaworks.deliveryapi.api.model;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class RecipientModel {

    private String name;
    private String street;
    private String number;
    private String complement;
    private String district;
}
