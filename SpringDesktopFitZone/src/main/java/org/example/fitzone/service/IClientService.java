package org.example.fitzone.service;

import org.example.fitzone.model.Client;
import java.util.List;

public interface IClientService {
    public List<Client> findAllClients();
    public Client findClientById(Integer client);
    public void saveClient(Client client);
    public void deleteClientById(Integer client);
}
