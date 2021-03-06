package com.trust.app.model;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
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
@Table(name="FACTUREVENTE")
@ManagedBean(name="factureVente")
@Data
public class FactureVente extends Facture{
	

	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "factureVente_id")
	private List<LigneLivraison> ligneLivraisons;
	
	
}
