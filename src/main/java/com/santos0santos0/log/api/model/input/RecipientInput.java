package com.santos0santos0.log.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class RecipientInput {

    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @NotBlank
    private String number;

    @NotBlank
    private String complement;

    @NotBlank
    private String district;

}
