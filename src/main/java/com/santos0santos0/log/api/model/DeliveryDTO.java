package com.santos0santos0.log.api.model;

import com.santos0santos0.log.domain.model.StatusDelivery;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class DeliveryDTO {

    private Long id;
    private ClientResumeDTO client;
    private RecipientDTO recipient;
    private BigDecimal tax;
    private StatusDelivery status;
    private OffsetDateTime dateOrder;
    private OffsetDateTime dateFinalization;

}
