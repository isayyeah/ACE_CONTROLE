package com.client.Client.services;

import com.client.Client.entities.Client;
import com.client.Client.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServices {

    private final ClientRepository clientRepositoryr;

    public void save(Client client){
        clientRepositoryr.save(client);
    }

    public void update(Client client){
        clientRepositoryr.save(client);
    }

    public void delete(Client client){
        clientRepositoryr.delete(client);
    }

    public Client findClient(int id) throws Exception{
        return clientRepositoryr.findById(id).orElseThrow(
                () -> new Exception("Invalid client ID!!!")
        );
    }

    public List<Client> findAll(){
        return clientRepositoryr.findAll();
    }
}
