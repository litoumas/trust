package com.trust.app.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trust.app.dao.LigneLivraisonDAO;
import com.trust.app.model.LigneLivraison;

@Service
@ManagedBean(name = "ligneLivraisonService")
@SessionScoped
public class LigneLivraisonServiceImpl implements LigneLivraisonService {

	private LigneLivraisonDAO LigneLivraisonDAO;

	public void setLigneLivraisonDAO(LigneLivraisonDAO LigneLivraisonDAO) {
		this.LigneLivraisonDAO = LigneLivraisonDAO;
	}

	@Override
	@Transactional
	public List<LigneLivraison> listLigneLivraisons() {
		return this.LigneLivraisonDAO.listLigneLivraisons();
	}

	@Override
	@Transactional
	public void addLigneLivraison(LigneLivraison u) {
		this.LigneLivraisonDAO.addLigneLivraison(u);

	}

	@Override
	@Transactional
	public void deleteLigneLivraison(LigneLivraison u) {
		this.LigneLivraisonDAO.deleteLigneLivraison(u);

	}

	@Override
	@Transactional
	public void updateLigneLivraison(LigneLivraison u) {
		this.LigneLivraisonDAO.updateLigneLivraison(u);

	}

}