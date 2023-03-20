package com.algaworks.deliveryapi.api.model;

import com.algaworks.deliveryapi.domain.model.DeliveryStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter @Setter
public class DeliveryOutput {
    private Long id;
    private String clientName;
    private RecipientModel recipient;
    private BigDecimal tax;
    private DeliveryStatus deliveryStatus;
    private OffsetDateTime orderDate;
    private OffsetDateTime deliveredDate;

}
