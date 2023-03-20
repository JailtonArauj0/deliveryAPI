package com.algaworks.deliveryapi.domain.model;

import com.algaworks.deliveryapi.GroupValidation;
import com.algaworks.deliveryapi.domain.exception.CustomException;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter @EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Delivery {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Valid
    @ConvertGroup(from = Default.class, to = GroupValidation.ClientId.class)
    @NotNull
    @ManyToOne
    private Client client;

    @Valid
    @NotNull
    @Embedded
    private Recipient recipient;

    @NotNull
    @Column(nullable = false)
    private BigDecimal tax;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<Occurence> occurences = new ArrayList<>();

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeliveryStatus status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(nullable = false)
    private OffsetDateTime orderDate;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime endDate;

    public Occurence addOccurence(String description) {
        Occurence occurence = new Occurence();
        occurence.setDescription(description);
        occurence.setRegisterDate(OffsetDateTime.now());
        occurence.setDelivery(this);

        this.getOccurences().add(occurence);
        return occurence;
    }

    public void end() {
        if (!DeliveryStatus.PENDENTE.equals(getStatus())) {
            throw new CustomException("Não foi possível finalizar a entrega!");
        }
        setStatus(DeliveryStatus.FINALIZADA);
        setEndDate(OffsetDateTime.now());
    }


}
