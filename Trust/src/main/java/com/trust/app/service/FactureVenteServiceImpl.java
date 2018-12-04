package com.trust.app.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trust.app.dao.FactureVenteDAO;
import com.trust.app.model.FactureVente;

@Service
@ManagedBean(name = "factureVenteService")
@SessionScoped
public class FactureVenteServiceImpl implements FactureVenteService {

	private FactureVenteDAO FactureVenteDAO;

	public void setFactureVenteDAO(FactureVenteDAO FactureVenteDAO) {
		this.FactureVenteDAO = FactureVenteDAO;
	}

	@Override
	@Transactional
	public List<FactureVente> listFactureVentes() {
		return this.FactureVenteDAO.listFactureVentes();
	}

	@Override
	@Transactional
	public void addFactureVente(FactureVente u) {
		this.FactureVenteDAO.addFactureVente(u);

	}

	@Override
	@Transactional
	public void deleteFactureVente(FactureVente u) {
		this.FactureVenteDAO.deleteFactureVente(u);

	}

	@Override
	@Transactional
	public void updateFactureVente(FactureVente u) {
		this.FactureVenteDAO.updateFactureVente(u);

	}


}