package com.trust.app.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.hibernate.SessionFactory;

import com.trust.app.model.Article;
import com.trust.app.service.MvtStockService;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "MvtStockBean")
@SessionScoped
public class MvtStockBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4982965584511923474L;


	@Getter
	@Setter
	
	private SessionFactory sessionFactory;
	
	
	@Getter
	@Setter
	@ManagedProperty("#{mvtStockService}")
	private MvtStockService mvtStockService;
	
	public Double getStockTotal(Article article)
	{
		return mvtStockService.getStockTotal(article);
	}
	
	public Double getStockBlack(Article article)
	{
		return mvtStockService.getStockBlack(article);
	}
	public Double getStockDeclarer(Article article)
	{
		return mvtStockService.getStockDeclarer(article);
	}
	public Double getStockSuspense(Article article)
	{
		return getStockTotal(article)-(getStockDeclarer(article)+getStockBlack(article));
	}
}
