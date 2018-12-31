package com.trust.app.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trust.app.dao.GrandLivreDAO;
import com.trust.app.model.GrandLivre;

@Service
@ManagedBean(name = "grandLivreService")
@SessionScoped
public class GrandLivreServiceImpl implements GrandLivreService {

	private GrandLivreDAO grandLivreDAO;

	public void setGrandLivreDAO(GrandLivreDAO grandLivreDAO) {
		this.grandLivreDAO = grandLivreDAO;
	}

	@Override
	@Transactional
	public List<GrandLivre> listGrandLivres() {
		return this.grandLivreDAO.listGrandLivres();
	}

	@Override
	@Transactional
	public void addGrandLivre(GrandLivre u) {
		this.grandLivreDAO.addGrandLivre(u);

	}

	@Override
	@Transactional
	public void deleteGrandLivre(GrandLivre u) {
		this.grandLivreDAO.deleteGrandLivre(u);

	}

	@Override
	@Transactional
	public void updateGrandLivre(GrandLivre u) {
		this.grandLivreDAO.updateGrandLivre(u);

	}


}