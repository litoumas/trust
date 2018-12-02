package com.trust.app.service;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.trust.app.dao.TracteurDAO;
import com.trust.app.model.MarqueTracteur;
import com.trust.app.model.Tracteur;


@Service
@ManagedBean(name = "tracteurService")
@SessionScoped
public class TracteurServiceImpl implements TracteurService,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1120798525255629783L;
	private static final Logger logger = LoggerFactory.getLogger(TracteurServiceImpl.class);
	private TracteurDAO tracteurDAO;

	public void setTracteurDAO(TracteurDAO tracteurDAO) {
		this.tracteurDAO = tracteurDAO;
	}

	@Override
	@Transactional
	public void addTracteur(Tracteur c) {
		this.tracteurDAO.addTracteur(c);
	}

	@Override
	@Transactional
	public List<Tracteur> listTracteurs() {
		return this.tracteurDAO.listTracteurs();
	}

	@Override
	@Transactional
	public void deleteTracteur(Tracteur c) {
		this.tracteurDAO.deleteTracteur(c);
	}

	@Override
	@Transactional
	public void updateTracteur(Tracteur c) {
		this.tracteurDAO.updateTracteur(c);
	}

	@Override
	public void testLog() {
		
	}

	@Override
	@Transactional
	public Tracteur find(String designation, MarqueTracteur selectedMarqueTracteur) {
		return this.tracteurDAO.find(designation, selectedMarqueTracteur);
		
	}

}