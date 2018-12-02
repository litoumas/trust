package com.trust.app.service;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.trust.app.dao.FactureFournisseurDAO;
import com.trust.app.model.FactureFournisseur;


@Service
@ManagedBean(name = "factureFournisseurService")
@SessionScoped
public class FactureFournisseurServiceImpl implements FactureFournisseurService,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1525098787267710537L;
	/**
	 * 
	 */
	private static final Logger logger = LoggerFactory.getLogger(FactureFournisseurServiceImpl.class);
	private FactureFournisseurDAO FactureFournisseurDAO;

	public void setFactureFournisseurDAO(FactureFournisseurDAO FactureFournisseurDAO) {
		this.FactureFournisseurDAO = FactureFournisseurDAO;
	}

	@Override
	@Transactional
	public void addFactureFournisseur(FactureFournisseur c) {
		this.FactureFournisseurDAO.addFactureFournisseur(c);
	}

	@Override
	@Transactional
	public List<FactureFournisseur> listFactureFournisseurs() {
		return this.FactureFournisseurDAO.listFactureFournisseurs();
	}

	@Override
	@Transactional
	public void deleteFactureFournisseur(FactureFournisseur c) {
		this.FactureFournisseurDAO.deleteFactureFournisseur(c);
	}

	@Override
	@Transactional
	public void updateFactureFournisseur(FactureFournisseur c) {
		this.FactureFournisseurDAO.updateFactureFournisseur(c);
	}

	@Override
	public void testLog() {
		
	}


}