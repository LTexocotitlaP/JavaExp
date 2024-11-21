package org.example.zonafit.interfaces;

import org.example.zonafit.models.Client;
import java.util.List;

public interface IClient {

    List<Client> getAll();
    boolean getById(Client client);
    boolean add(Client client);
    boolean update(Client client);
    boolean delete(Client client);

}
