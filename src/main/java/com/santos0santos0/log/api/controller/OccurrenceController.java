package com.santos0santos0.log.api.controller;

import com.santos0santos0.log.api.assembler.OccurrenceAssembler;
import com.santos0santos0.log.api.model.OccurrenceDTO;
import com.santos0santos0.log.api.model.input.OccurrenceInput;
import com.santos0santos0.log.domain.model.Delivery;
import com.santos0santos0.log.domain.model.Occurrence;
import com.santos0santos0.log.domain.service.RecordOccurrenceService;
import com.santos0santos0.log.domain.service.SearchDeliveryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("deliveries/{id}/occurrences")
public class OccurrenceController {

    private SearchDeliveryService searchDeliveryService;
    private RecordOccurrenceService recordOccurrenceService;
    private OccurrenceAssembler occurrenceAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OccurrenceDTO register(@PathVariable Long id,
                                  @Valid @RequestBody OccurrenceInput occurrenceInput) {
        Occurrence occurrenceRegister = recordOccurrenceService
                .register(id, occurrenceInput.getDescription());

        return occurrenceAssembler.toModel(occurrenceRegister);
    }

    @GetMapping
    public List<OccurrenceDTO> list(@PathVariable Long id) {
        Delivery delivery = searchDeliveryService.search(id);
        return occurrenceAssembler.toCollectionModel(delivery.getOccurrences());
    }

}
