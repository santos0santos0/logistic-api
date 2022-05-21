package com.santos0santos0.log.api.controller;

import com.santos0santos0.log.domain.model.Delivery;
import com.santos0santos0.log.domain.service.RequestDeliveryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    private RequestDeliveryService requestDeliveryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Delivery add(@RequestBody Delivery delivery) {
        return requestDeliveryService.request(delivery);
    }

}
