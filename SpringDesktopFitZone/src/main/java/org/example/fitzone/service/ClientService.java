package org.example.fitzone.service;

import org.example.fitzone.model.Client;
import org.example.fitzone.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientService implements IClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> findAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients;
    }

    @Override
    public Client findClientById(Integer clientId) {
        return clientRepository.findById(clientId).get();
    }

    @Override
    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void deleteClientById(Integer clientId) {
        clientRepository.deleteById(clientId);
    }

}
