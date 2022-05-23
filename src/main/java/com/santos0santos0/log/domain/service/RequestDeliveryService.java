package com.santos0santos0.log.domain.service;

import com.santos0santos0.log.domain.model.Client;
import com.santos0santos0.log.domain.model.Delivery;
import com.santos0santos0.log.domain.model.StatusDelivery;
import com.santos0santos0.log.domain.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@Service
@AllArgsConstructor
public class RequestDeliveryService {

    private CatalogClientService catalogClientService;
    private DeliveryRepository deliveryRepository;

    @Transactional
    public Delivery request(Delivery delivery) {
        Client client = catalogClientService.search(delivery.getClient().getId());
        delivery.setClient(client);
        delivery.setStatus(StatusDelivery.PENDING);
        delivery.setDateOrder(OffsetDateTime.now());

        return deliveryRepository.save(delivery);
    }

}
