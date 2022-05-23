package com.santos0santos0.log.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class OccurrenceInput {

    @NotBlank
    private String description;

}
