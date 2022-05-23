package com.santos0santos0.log.domain.service;

import com.santos0santos0.log.domain.model.Delivery;
import com.santos0santos0.log.domain.model.Occurrence;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RecordOccurrenceService {

    private SearchDeliveryService searchDeliveryService;

    @Transactional
    public Occurrence register(Long id, String description) {
        Delivery delivery = searchDeliveryService.search(id);
        return delivery.addOccurrence(description);
    }

}
