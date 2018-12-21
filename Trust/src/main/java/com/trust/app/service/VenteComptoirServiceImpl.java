package com.trust.app.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trust.app.dao.VenteComptoirDAO;
import com.trust.app.model.LigneVenteComptoir;
import com.trust.app.model.VenteComptoir;

@Service
@ManagedBean(name = "venteComptoirService")
@SessionScoped
public class VenteComptoirServiceImpl implements VenteComptoirService {

	private VenteComptoirDAO venteComptoirDAO;

	public void setVenteComptoirDAO(VenteComptoirDAO VenteComptoirDAO) {
		this.venteComptoirDAO = VenteComptoirDAO;
	}

	@Override
	@Transactional
	public List<VenteComptoir> listVenteComptoirs() {
		return this.venteComptoirDAO.listVenteComptoirs();
	}

	@Override
	@Transactional
	public void addVenteComptoir(VenteComptoir u) {
		this.venteComptoirDAO.addVenteComptoir(u);

	}

	@Override
	@Transactional
	public void deleteVenteComptoir(VenteComptoir u) {
		this.venteComptoirDAO.deleteVenteComptoir(u);

	}

	@Override
	@Transactional
	public void updateVenteComptoir(VenteComptoir u) {
		this.venteComptoirDAO.updateVenteComptoir(u);

	}



}