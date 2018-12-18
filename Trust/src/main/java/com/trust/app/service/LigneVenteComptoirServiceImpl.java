package com.trust.app.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trust.app.dao.LigneVenteComptoirDAO;
import com.trust.app.model.LigneVenteComptoir;

@Service
@ManagedBean(name = "ligneVenteComptoirService")
@SessionScoped
public class LigneVenteComptoirServiceImpl implements LigneVenteComptoirService {

	private LigneVenteComptoirDAO ligneVenteComptoirDAO;

	public void setLigneVenteComptoirDAO(LigneVenteComptoirDAO LigneVenteComptoirDAO) {
		this.ligneVenteComptoirDAO = LigneVenteComptoirDAO;
	}

	@Override
	@Transactional
	public List<LigneVenteComptoir> listLigneVenteComptoirs() {
		return this.ligneVenteComptoirDAO.listLigneVenteComptoirs();
	}

	@Override
	@Transactional
	public void addLigneVenteComptoir(LigneVenteComptoir u) {
		this.ligneVenteComptoirDAO.addLigneVenteComptoir(u);

	}

	@Override
	@Transactional
	public void deleteLigneVenteComptoir(LigneVenteComptoir u) {
		this.ligneVenteComptoirDAO.deleteLigneVenteComptoir(u);

	}

	@Override
	@Transactional
	public void updateLigneVenteComptoir(LigneVenteComptoir u) {
		this.ligneVenteComptoirDAO.updateLigneVenteComptoir(u);

	}


}