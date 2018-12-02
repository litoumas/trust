package com.trust.app.service;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.trust.app.dao.MarqueTracteurDAO;
import com.trust.app.model.MarqueTracteur;


@Service
@ManagedBean(name = "marqueTracteurService")
@SessionScoped
public class MarqueTracteurServiceImpl implements MarqueTracteurService,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1120798525255629783L;
	private static final Logger logger = LoggerFactory.getLogger(MarqueTracteurServiceImpl.class);
	private MarqueTracteurDAO marqueTracteurDAO;

	public void setMarqueTracteurDAO(MarqueTracteurDAO marqueTracteurDAO) {
		this.marqueTracteurDAO = marqueTracteurDAO;
	}

	@Override
	@Transactional
	public void addMarqueTracteur(MarqueTracteur c) {
		this.marqueTracteurDAO.addMarqueTracteur(c);
	}

	@Override
	@Transactional
	public List<MarqueTracteur> listMarqueTracteurs() {
		return this.marqueTracteurDAO.listMarqueTracteurs();
	}

	@Override
	@Transactional
	public void deleteMarqueTracteur(MarqueTracteur c) {
		this.marqueTracteurDAO.deleteMarqueTracteur(c);
	}

	@Override
	@Transactional
	public void updateMarqueTracteur(MarqueTracteur c) {
		this.marqueTracteurDAO.updateMarqueTracteur(c);
	}

	@Override
	public void testLog() {
		
	}

	@Override
	@Transactional
	public MarqueTracteur findWithDesig(String designation) {
		return this.marqueTracteurDAO.findWithDesig(designation);
		
	}

}