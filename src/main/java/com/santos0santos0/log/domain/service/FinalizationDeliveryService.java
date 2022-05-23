package com.santos0santos0.log.domain.service;

import com.santos0santos0.log.domain.exception.DomainException;
import com.santos0santos0.log.domain.model.Delivery;
import com.santos0santos0.log.domain.model.StatusDelivery;
import com.santos0santos0.log.domain.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class FinalizationDeliveryService {

    private DeliveryRepository deliveryRepository;
    private SearchDeliveryService searchDeliveryService;

    @Transactional
    public void finish(Long id) {
        Delivery delivery = searchDeliveryService.search(id);

        delivery.finished();

        deliveryRepository.save(delivery);
    }

}
