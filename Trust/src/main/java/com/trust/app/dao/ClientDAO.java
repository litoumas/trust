package com.trust.app.dao;

import java.util.List;

import com.trust.app.model.Client;

public interface ClientDAO {

	public void addClient(Client p);
    public List<Client> listClients();
    public void deleteClient(Client p);
    public void updateClient(Client p);
	public Client findWithName(String nom);
	public Client getClientPassager();
	
}
