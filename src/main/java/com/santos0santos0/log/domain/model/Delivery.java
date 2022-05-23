package com.santos0santos0.log.domain.model;

import com.santos0santos0.log.domain.ValidationGroups;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Delivery {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ConvertGroup(from = Default.class, to = ValidationGroups.ClientId.class)
    @ManyToOne
    private Client client;

    @Embedded
    private Recipient recipient;

    private BigDecimal tax;

    @Enumerated(EnumType.STRING)
    private StatusDelivery status;

    private OffsetDateTime dateOrder;

    private OffsetDateTime dateFinalization;

}
