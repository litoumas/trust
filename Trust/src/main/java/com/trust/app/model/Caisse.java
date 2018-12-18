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
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="CAISSE")
@ManagedBean(name="caisse")
@Data
public class Caisse implements Document {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	Date heurOuverture;
	Date heurCloture;
	float argentDepart;
	float argentCloture;
	
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "caisse_id")
	private List<VenteComptoir> listeventeComptoirs;


	public void addVente(VenteComptoir venteComptoir) {
		listeventeComptoirs.add(venteComptoir);
	}
}
