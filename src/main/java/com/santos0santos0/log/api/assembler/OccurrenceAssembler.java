package com.santos0santos0.log.api.assembler;

import com.santos0santos0.log.api.model.OccurrenceDTO;
import com.santos0santos0.log.domain.model.Occurrence;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class OccurrenceAssembler {

    private ModelMapper modelMapper;

    public OccurrenceDTO toModel(Occurrence occurrence) {
        return modelMapper.map(occurrence, OccurrenceDTO.class);
    }

    public List<OccurrenceDTO> toCollectionModel(List<Occurrence> occurrences) {
        return occurrences.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

}
