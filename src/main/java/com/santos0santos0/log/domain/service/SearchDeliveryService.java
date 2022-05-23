package com.santos0santos0.log.domain.service;

import com.santos0santos0.log.domain.exception.DomainException;
import com.santos0santos0.log.domain.exception.EntityNotFoundException;
import com.santos0santos0.log.domain.model.Delivery;
import com.santos0santos0.log.domain.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SearchDeliveryService {

    private DeliveryRepository deliveryRepository;

    public Delivery search(Long id) {
        return deliveryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Delivery not found"));
    }

}
