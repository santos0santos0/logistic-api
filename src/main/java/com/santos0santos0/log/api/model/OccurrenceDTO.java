package com.santos0santos0.log.api.model;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class OccurrenceDTO {

    private Long id;
    private String description;
    private OffsetDateTime dateRecord;

}
