package com.trust.app.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
@Table(name = "CAISSE")
@ManagedBean(name = "caisse")
@Data
public class Caisse {
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

	public List<LigneVenteComptoir> getAllLigneVenteComtoir() {

		List<LigneVenteComptoir> ListeLigne = new ArrayList<LigneVenteComptoir>();

		Iterator<VenteComptoir> iterator = getListeventeComptoirs().iterator();
		while (iterator.hasNext()) {
			VenteComptoir vente = iterator.next();
			ListeLigne.addAll(vente.getListeligneVenteComptoir());

		}
		return ListeLigne;
	}

	public List<LigneVenteComptoir> getLigneVenteComtoirNoir() {
		List<LigneVenteComptoir> ListeLigne = new ArrayList<LigneVenteComptoir>();

		Iterator<VenteComptoir> iterator = getListeventeComptoirs().iterator();
		while (iterator.hasNext()) {
			VenteComptoir vente = iterator.next();
			ListeLigne.addAll(vente.getListeligneVenteComptoirNoir());

		}
		return ListeLigne;
	}

	public List<LigneVenteComptoir> getLigneVenteSuspens() {
		List<LigneVenteComptoir> ListeLigne = new ArrayList<LigneVenteComptoir>();

		Iterator<VenteComptoir> iterator = getListeventeComptoirs().iterator();
		while (iterator.hasNext()) {
			VenteComptoir vente = iterator.next();
			ListeLigne.addAll(vente.getListeligneVenteComptoirSuspens());

		}
		return ListeLigne;
	}

}
