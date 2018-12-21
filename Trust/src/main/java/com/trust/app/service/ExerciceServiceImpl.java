package com.trust.app.service;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.trust.app.dao.ExerciceDAO;
import com.trust.app.model.Exercice;


@Service
@ManagedBean(name = "ExerciceService")
@SessionScoped
public class ExerciceServiceImpl implements ExerciceService,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1120798525255629783L;
	private static final Logger logger = LoggerFactory.getLogger(ExerciceServiceImpl.class);
	private ExerciceDAO ExerciceDAO;

	public void setExerciceDAO(ExerciceDAO ExerciceDAO) {
		this.ExerciceDAO = ExerciceDAO;
	}

	@Override
	@Transactional
	public void addExercice(Exercice c) {
		this.ExerciceDAO.addExercice(c);
	}

	@Override
	@Transactional
	public List<Exercice> listExercices() {
		return this.ExerciceDAO.listExercices();
	}

	@Override
	@Transactional
	public void deleteExercice(Exercice c) {
		this.ExerciceDAO.deleteExercice(c);
	}

	@Override
	@Transactional
	public void updateExercice(Exercice c) {
		this.ExerciceDAO.updateExercice(c);
	}

	@Override
	public void testLog() {
		
	}

	@Override
	@Transactional
	public Exercice getLastOne() {
		// TODO Auto-generated method stub
		return this.ExerciceDAO.getLastOne();
	}

}