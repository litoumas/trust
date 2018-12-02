package com.trust.app.service;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.trust.app.dao.LigneVenteDAO;
import com.trust.app.model.LigneVente;


@Service
@ManagedBean(name = "ligneVenteService")
@SessionScoped
public class LigneVenteServiceImpl implements LigneVenteService,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1120798525255629783L;
	private static final Logger logger = LoggerFactory.getLogger(LigneVenteServiceImpl.class);
	private LigneVenteDAO LigneVenteDAO;

	public void setLigneVenteDAO(LigneVenteDAO LigneVenteDAO) {
		this.LigneVenteDAO = LigneVenteDAO;
	}

	@Override
	@Transactional
	public void addLigneVente(LigneVente c) {
		this.LigneVenteDAO.addLigneVente(c);
	}

	@Override
	@Transactional
	public List<LigneVente> listLigneVentes() {
		return this.LigneVenteDAO.listLigneVentes();
	}

	@Override
	@Transactional
	public void deleteLigneVente(LigneVente c) {
		this.LigneVenteDAO.deleteLigneVente(c);
	}

	@Override
	@Transactional
	public void updateLigneVente(LigneVente c) {
		this.LigneVenteDAO.updateLigneVente(c);
	}

	@Override
	public void testLog() {
		
	}

}