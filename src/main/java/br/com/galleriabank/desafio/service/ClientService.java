package br.com.galleriabank.desafio.service;

import br.com.galleriabank.desafio.exception.BusinessException;
import br.com.galleriabank.desafio.model.dto.request.CreateClientRequest;
import br.com.galleriabank.desafio.model.entity.Client;
import br.com.galleriabank.desafio.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public Client createClient(CreateClientRequest request) {
        if (clientRepository.existsByCpf(request.cpf()))
            throw new BusinessException("CPF already exists");

        Client client = new Client();
        client.setCpf(request.cpf());
        client.setName(request.name());
        client.setPhoneNumber(request.phoneNumber());

        return clientRepository.save(client);
    }
}
