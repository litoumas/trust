package com.trust.app.dao;

import java.util.List;
import com.trust.app.model.Article;
/**
 * Car data access object interface
 * */

public interface CarDAO {
	
	public void addCar(Article p);
    public List<Article> listCars();
    public void deleteCar(Article p);
    public void updateCar(Article p);

}
