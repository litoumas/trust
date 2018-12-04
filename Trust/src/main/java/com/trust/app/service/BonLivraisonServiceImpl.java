package com.trust.app.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trust.app.dao.BonLivraisonDAO;
import com.trust.app.model.BonLivraison;

@Service
@ManagedBean(name = "bonLivraisonService")
@SessionScoped
public class BonLivraisonServiceImpl implements BonLivraisonService {

	private BonLivraisonDAO BonLivraisonDAO;

	public void setBonLivraisonDAO(BonLivraisonDAO BonLivraisonDAO) {
		this.BonLivraisonDAO = BonLivraisonDAO;
	}

	@Override
	@Transactional
	public List<BonLivraison> listBonLivraisons() {
		return this.BonLivraisonDAO.listBonLivraisons();
	}

	@Override
	@Transactional
	public void addBonLivraison(BonLivraison u) {
		this.BonLivraisonDAO.addBonLivraison(u);

	}

	@Override
	@Transactional
	public void deleteBonLivraison(BonLivraison u) {
		this.BonLivraisonDAO.deleteBonLivraison(u);

	}

	@Override
	@Transactional
	public void updateBonLivraison(BonLivraison u) {
		this.BonLivraisonDAO.updateBonLivraison(u);

	}


}