package com.trust.app.service;

import java.util.List;

import com.trust.app.model.Article;

public interface CarService {
	
	public void addCar(Article c);
    public List<Article> listCars();
    public void deleteCar(Article c);
    public void updateCar(Article c);
    public void testLog();
}
