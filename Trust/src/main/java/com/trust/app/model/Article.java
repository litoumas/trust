package com.trust.app.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trust.app.bean.MvtStockBean;
import com.trust.app.service.MvtStockService;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation
 */
@Entity
@Table(name = "ARTICLE")
@ManagedBean(name = "article")
@Data
public class Article {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "note")
	private String note;

	@Column(name = "prixvente")
	private float prixvente;

	@Column(name = "prixmini")
	private float prixmini;

	@Column(name = "prixVenteDeclare")
	private float prixVenteDeclare;

	@Column(name = "position")
	private String position;

	@OneToOne
	Item item;

	@OneToOne
	Marque marque;

	


	public float getStockTotal() {
		
		return 0;
	}

	public float getStockDeclarer() {
		return 0;
	}

	public float getStockNoir() {
		return 0;
	}

}