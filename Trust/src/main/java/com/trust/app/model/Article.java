package com.trust.app.model;



import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 */
@Entity
@Table(name="ARTICLE")
@ManagedBean(name="article")
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

	@OneToOne
	Item item;

	@OneToOne
	Marque marque;

	

}