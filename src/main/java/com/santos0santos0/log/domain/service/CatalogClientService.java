package com.santos0santos0.log.domain.service;

import com.santos0santos0.log.domain.exception.DomainException;
import com.santos0santos0.log.domain.model.Client;
import com.santos0santos0.log.domain.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CatalogClientService {

    private ClientRepository clientRepository;

    public Client search(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new DomainException("Client not found"));
    }

    @Transactional
    public Client save(Client client) {
        boolean email = clientRepository.findByEmail(client.getEmail())
                .stream()
                .anyMatch(clientExistent -> !clientExistent.equals(client));

        if (email) {
            throw new DomainException("E-mail already registered");
        }

        return clientRepository.save(client);
    }

    @Transactional
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

}
