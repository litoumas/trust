package com.trust.app.service;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.trust.app.dao.CarDAO;
import com.trust.app.model.Article;


@Service
@ManagedBean(name = "carService")
@SessionScoped
public class CarServiceImpl implements CarService,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1120798525255629783L;
	private static final Logger logger = LoggerFactory.getLogger(CarServiceImpl.class);
	private CarDAO carDAO;

	public void setCarDAO(CarDAO carDAO) {
		this.carDAO = carDAO;
	}

	@Override
	@Transactional
	public void addCar(Article c) {
		this.carDAO.addCar(c);
	}

	@Override
	@Transactional
	public List<Article> listCars() {
		return this.carDAO.listCars();
	}

	@Override
	@Transactional
	public void deleteCar(Article c) {
		this.carDAO.deleteCar(c);
	}

	@Override
	@Transactional
	public void updateCar(Article c) {
		this.carDAO.updateCar(c);
	}

	@Override
	public void testLog() {
		
	}

}