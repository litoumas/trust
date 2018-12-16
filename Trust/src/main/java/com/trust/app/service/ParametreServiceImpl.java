package com.trust.app.service;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.trust.app.dao.ParametreDAO;
import com.trust.app.model.Parametre;


@Service
@ManagedBean(name = "parametreService")
@SessionScoped
public class ParametreServiceImpl implements ParametreService,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1120798525255629783L;
	private static final Logger logger = LoggerFactory.getLogger(ParametreServiceImpl.class);
	private ParametreDAO ParametreDAO;

	public void setParametreDAO(ParametreDAO ParametreDAO) {
		this.ParametreDAO = ParametreDAO;
	}

	@Override
	@Transactional
	public void addParametre(Parametre c) {
		this.ParametreDAO.addParametre(c);
	}

	@Override
	@Transactional 
	public List<Parametre> listParametres() {
		return this.ParametreDAO.listParametres();
	}

	@Override
	@Transactional
	public void deleteParametre(Parametre c) {
		this.ParametreDAO.deleteParametre(c);
	}

	@Override
	@Transactional
	public void updateParametre(Parametre c) {
		this.ParametreDAO.updateParametre(c);
	}

	@Override
	public void testLog() {
		
	}

	@Override
	@Transactional
	public Parametre getParametre(String nomParametre) {
		return this.ParametreDAO.getParametre(nomParametre);
		
	}

}