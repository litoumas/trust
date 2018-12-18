package com.trust.app.service;

import java.util.List;

import com.trust.app.model.Client;

public interface ClientService {
	
	public void addClient(Client c);
    public List<Client> listClients();
    public void deleteClient(Client c);
    public void updateClient(Client c);
    public void testLog();
	public Client findWithName(String nom);
	public Client getClientPassager();
}
