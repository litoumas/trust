package com.trust.app.service;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.trust.app.dao.BonReceptionDAO;
import com.trust.app.model.BonReception;
import com.trust.app.model.Fournisseur;

import lombok.Getter;
import lombok.Setter;


@Service
@ManagedBean(name = "bonReceptionService")
@SessionScoped
public class BonReceptionServiceImpl implements BonReceptionService,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1120798525255629783L;
	private static final Logger logger = LoggerFactory.getLogger(BonReceptionServiceImpl.class);

	@Getter
	@Setter
	private BonReceptionDAO bonReceptionDAO;


	@Override
	@Transactional
	public void addBonReception(BonReception c) {
		this.bonReceptionDAO.addBonReception(c);
	}

	@Override
	@Transactional
	public List<BonReception> listBonReceptions() {
		return this.bonReceptionDAO.listBonReceptions();
	}

	@Override
	@Transactional
	public void deleteBonReception(BonReception c) {
		this.bonReceptionDAO.deleteBonReception(c);
	}

	@Override
	@Transactional
	public void updateBonReception(BonReception c) {
		this.bonReceptionDAO.updateBonReception(c);
	}

	@Override
	public void testLog() {
		
	}

	@Override
	@Transactional
	public List<BonReception> listBonReceptions(Fournisseur fournisseur) {
		return this.bonReceptionDAO.listBonReceptions(fournisseur);
	}

	@Override
	@Transactional
	public List<BonReception> listBonReceptions(Fournisseur fournisseur, boolean isblack) {
		return this.bonReceptionDAO.listBonReceptions(fournisseur,isblack);
	}

	@Override
	@Transactional
	public List<BonReception> listBonReceptions(Fournisseur fournisseur, boolean isblack, boolean hasInvoice) {
		return this.bonReceptionDAO.listBonReceptions(fournisseur,isblack,hasInvoice);
	}

}