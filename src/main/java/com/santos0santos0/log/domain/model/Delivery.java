package com.santos0santos0.log.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Delivery {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Client client;

    @Embedded
    private Recipient recipient;
    private BigDecimal tax;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Enumerated(EnumType.STRING)
    private StatusDelivery status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dateOrder;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dateFinalization;

}
