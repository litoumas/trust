package com.trust.app.service;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.trust.app.dao.LigneReceptionDAO;
import com.trust.app.model.LigneReception;


@Service
@ManagedBean(name = "ligneReceptionService")
@SessionScoped
public class LigneReceptionServiceImpl implements LigneReceptionService,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1120798525255629783L;
	private static final Logger logger = LoggerFactory.getLogger(LigneReceptionServiceImpl.class);
	private LigneReceptionDAO ligneReceptionDAO;

	public void setLigneReceptionDAO(LigneReceptionDAO LigneReceptionDAO) {
		this.ligneReceptionDAO = LigneReceptionDAO;
	}

	@Override
	@Transactional
	public void addLigneReception(LigneReception c) {
		this.ligneReceptionDAO.addLigneReception(c);
	}

	@Override
	@Transactional
	public List<LigneReception> listLigneReceptions() {
		return this.ligneReceptionDAO.listLigneReceptions();
	}

	@Override
	@Transactional
	public void deleteLigneReception(LigneReception c) {
		this.ligneReceptionDAO.deleteLigneReception(c);
	}

	@Override
	@Transactional
	public void updateLigneReception(LigneReception c) {
		this.ligneReceptionDAO.updateLigneReception(c);
	}

	@Override
	public void testLog() {
		
	}

}