package com.santos0santos0.log.api.assembler;

import com.santos0santos0.log.api.model.DeliveryDTO;
import com.santos0santos0.log.api.model.input.DeliveryInput;
import com.santos0santos0.log.domain.model.Delivery;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class DeliveryAssembler {

    private ModelMapper modelMapper;

    public DeliveryDTO toModel(Delivery delivery) {
        return modelMapper.map(delivery, DeliveryDTO.class);
    }

    public List<DeliveryDTO> toCollectionModel(List<Delivery> deliveries) {
        return deliveries.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public Delivery toEntity(DeliveryInput deliveryInput) {
        return modelMapper.map(deliveryInput, Delivery.class);
    }

}
