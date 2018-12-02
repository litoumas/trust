package com.trust.app.service;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.trust.app.dao.FournisseurDAO;
import com.trust.app.model.Fournisseur;


@Service
@ManagedBean(name = "fournisseurService")
@SessionScoped
public class FournisseurServiceImpl implements FournisseurService,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1120798525255629783L;
	private static final Logger logger = LoggerFactory.getLogger(FournisseurServiceImpl.class);
	private FournisseurDAO FournisseurDAO;

	public void setFournisseurDAO(FournisseurDAO FournisseurDAO) {
		this.FournisseurDAO = FournisseurDAO;
	}

	@Override
	@Transactional
	public void addFournisseur(Fournisseur c) {
		this.FournisseurDAO.addFournisseur(c);
	}

	@Override
	@Transactional
	public List<Fournisseur> listFournisseurs() {
		return this.FournisseurDAO.listFournisseurs();
	}

	@Override
	@Transactional
	public void deleteFournisseur(Fournisseur c) {
		this.FournisseurDAO.deleteFournisseur(c);
	}

	@Override
	@Transactional
	public void updateFournisseur(Fournisseur c) {
		this.FournisseurDAO.updateFournisseur(c);
	}

	@Override
	public void testLog() {
		
	}

	@Override
	@Transactional
	public Fournisseur findWithName(String nom) {
		// TODO Auto-generated method stub
		return this.FournisseurDAO.findWithName(nom);
	}

}