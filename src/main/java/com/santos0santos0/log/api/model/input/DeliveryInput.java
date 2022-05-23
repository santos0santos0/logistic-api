package com.santos0santos0.log.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class DeliveryInput {

    @Valid
    @NotNull
    private ClientIdInput client;

    @Valid
    @NotNull
    private RecipientInput recipient;

    @NotNull
    private BigDecimal tax;

}
