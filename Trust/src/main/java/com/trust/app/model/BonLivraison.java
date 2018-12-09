package com.trust.app.model;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="BONLIVRAISON")
@ManagedBean(name="BonLivraison")
@Data
public class BonLivraison {

	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "numero")
	private String numero;
	
	@OneToOne(cascade = CascadeType.ALL)
	Client client;

	@Column(name = "date")
	Date date;

	@Column(name = "isblack")
	boolean black;

	@OneToMany(fetch=FetchType.EAGER) 
	@JoinColumn(name = "Document_id")
	private List<LigneLivraison> ligneLivraisons;
	
	
	public void addLigne(LigneLivraison ligneLivraison) {
		ligneLivraisons.add(ligneLivraison);
	}
	
	
	
}
