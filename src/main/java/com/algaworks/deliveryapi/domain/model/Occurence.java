package com.algaworks.deliveryapi.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Getter @Setter @EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Occurence {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Delivery delivery;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private OffsetDateTime registerDate;



}
