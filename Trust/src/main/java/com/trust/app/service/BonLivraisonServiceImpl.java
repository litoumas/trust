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

	private BonLivraisonDAO bonLivraisonDAO;

	public void setBonLivraisonDAO(BonLivraisonDAO BonLivraisonDAO) {
		this.bonLivraisonDAO = BonLivraisonDAO;
	}

	@Override
	@Transactional
	public List<BonLivraison> listBonLivraisons() {
		return this.bonLivraisonDAO.listBonLivraisons();
	}

	@Override
	@Transactional
	public void addBonLivraison(BonLivraison u) {
		this.bonLivraisonDAO.addBonLivraison(u);

	}

	@Override
	@Transactional
	public void deleteBonLivraison(BonLivraison u) {
		this.bonLivraisonDAO.deleteBonLivraison(u);

	}

	@Override
	@Transactional
	public void updateBonLivraison(BonLivraison u) {
		this.bonLivraisonDAO.updateBonLivraison(u);

	}


}