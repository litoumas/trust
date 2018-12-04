package com.trust.app.model;

import java.util.ArrayList;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "BonReception")
@ManagedBean(name = "BonReception")
@Data
public class BonReception implements Document {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "numero")
	private String numero;
	
	
	@Column(name = "numero_bl")
	private String numero_bl;

	@OneToOne(cascade = CascadeType.ALL)
	Fournisseur fournisseur;

	@Column(name = "datereception")
	Date dateReception;

	@Column(name = "date_bl")
	Date date_bl;

	@Column(name = "isblack")
	boolean black;

	@OneToMany(fetch=FetchType.EAGER) 
	@JoinColumn(name = "Document_id")
	private List<LigneReception> ligneReceptions;
	
	

	

	
	public float getTotalHTVA() {
		if (getLigneReceptions() == null)
			return 0;
		float totalHTVA = 0;
		for (int i = 0; i <= getLigneReceptions().size() - 1; i++) {
			totalHTVA += getLigneReceptions().get(i).getPrix_total_HTVA();
		}
		return totalHTVA;
	}

	public float getTotalTTC() {
		if (getLigneReceptions() == null)
			return 0;
		float totalTTC = 0;
		for (int i = 0; i <= getLigneReceptions().size() - 1; i++) {
			totalTTC += getLigneReceptions().get(i).getPrix_total_ttc();
		}
		return totalTTC;
	}

}
