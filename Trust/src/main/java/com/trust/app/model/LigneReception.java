package com.trust.app.model;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "LIGNERECEPTION")
@ManagedBean(name = "ligneReception")
@Data
public class LigneReception extends MvtStock {


	@Column(name = "prix_ht")
	float prix_ht;

	@Column(name = "prix_ttc")
	float prix_ttc;

	@Column(name = "remise")
	int remise;

	@Column(name = "tva")
	int tva;

	public void setPrix_ht(float prix_ht) {
		this.prix_ht = prix_ht;
		calcul_prix_ttc();
	}

	public void setTva(int tva) {
		this.tva = tva;
		calcul_prix_ttc();
	}

	public void setRemise(int remise) {
		this.remise = remise;
		calcul_prix_ttc();
	}

	public void setPrix_ttc(float prix_ttc) {
		this.prix_ttc = arrondir(prix_ttc);
		calcul_prix_ht();
	}

	public void calcul_prix_ht() {
		float v_tva = arrondir((float) tva / 100);
		float v_remise = arrondir((float) remise / 100);
		float prix_htva = arrondir((float) prix_ttc / ((float) 1 + v_tva));
		prix_ht = (float) prix_htva / ((float) 1 + v_remise);
		prix_ht = arrondir(prix_ht);
	}

	public void calcul_prix_ttc() {
		float p_remise = arrondir((float) prix_ht * ((float) remise / 100));
		float prix_htva = prix_ht - p_remise;
		float p_tva = (float) prix_htva * ((float) tva / 100);
		prix_ttc = prix_htva + p_tva;
		prix_ttc = arrondir(prix_ttc);
	}

	public float getTotalBrute() { // prix brut sans TVA et sans Remise

		return getPrix_ht() * getQte();
	}

	public float getPrix_total_ttc() { // prix brut TTC

		return arrondir(getPrix_ttc() * getQte());
	}

	public void setPrix_total_ttc(float prix_total_ttc) {
		setPrix_ttc((float) prix_total_ttc / getQte());
	}

	public float getPrix_total_HTVA() {
		float p_remise = (float) getPrix_ht() * ((float) getRemise() / 100);
		return arrondir((getPrix_ht() - p_remise) * getQte());
	}

	public float arrondir(float nombre) {
		return (float) ((float) ((int) (nombre * Math.pow(10, 3) + .5)) / Math.pow(10, 3));
	}
}