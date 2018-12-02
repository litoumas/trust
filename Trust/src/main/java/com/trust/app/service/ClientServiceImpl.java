package com.trust.app.service;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.trust.app.dao.ClientDAO;
import com.trust.app.model.Client;


@Service
@ManagedBean(name = "clientService")
@SessionScoped
public class ClientServiceImpl implements ClientService,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1525098787267710537L;
	/**
	 * 
	 */
	private static final Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);
	private ClientDAO ClientDAO;

	public void setClientDAO(ClientDAO ClientDAO) {
		this.ClientDAO = ClientDAO;
	}

	@Override
	@Transactional
	public void addClient(Client c) {
		this.ClientDAO.addClient(c);
	}

	@Override
	@Transactional
	public List<Client> listClients() {
		return this.ClientDAO.listClients();
	}

	@Override
	@Transactional
	public void deleteClient(Client c) {
		this.ClientDAO.deleteClient(c);
	}

	@Override
	@Transactional
	public void updateClient(Client c) {
		this.ClientDAO.updateClient(c);
	}

	@Override
	public void testLog() {
		
	}

	@Override
	@Transactional
	public Client findWithName(String nom) {
		// TODO Auto-generated method stub
		return this.ClientDAO.findWithName(nom);
	}

}