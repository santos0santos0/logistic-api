package com.santos0santos0.log.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClientIdInput {

    @NotNull
    private Long id;

}
