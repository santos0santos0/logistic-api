package com.santos0santos0.log.api.controller;

import com.santos0santos0.log.api.assembler.DeliveryAssembler;
import com.santos0santos0.log.api.model.DeliveryDTO;
import com.santos0santos0.log.api.model.RecipientDTO;
import com.santos0santos0.log.api.model.input.DeliveryInput;
import com.santos0santos0.log.domain.model.Delivery;
import com.santos0santos0.log.domain.repository.DeliveryRepository;
import com.santos0santos0.log.domain.service.RequestDeliveryService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    private DeliveryRepository deliveryRepository;
    private RequestDeliveryService requestDeliveryService;
    private DeliveryAssembler deliveryAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeliveryDTO add(@Valid @RequestBody DeliveryInput deliveryInput) {
        Delivery newDelivery = deliveryAssembler.toEntity(deliveryInput);
        Delivery deliverySolicitation = requestDeliveryService.request(newDelivery);
        return deliveryAssembler.toModel(deliverySolicitation);
    }

    @GetMapping
    public List<DeliveryDTO> list() {
        return deliveryAssembler.toCollectionModel(deliveryRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryDTO> search(@PathVariable Long id) {
        return deliveryRepository.findById(id)
                .map(delivery -> ResponseEntity.ok(deliveryAssembler.toModel(delivery)))
                .orElse(ResponseEntity.notFound().build());
    }

}
