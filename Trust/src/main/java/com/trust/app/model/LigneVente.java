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

@Entity
@Table(name = "LIGNEVENTE")
@ManagedBean(name = "ligneVente")
@Data
public class LigneVente extends MvtStock{


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
		this.prix_ttc = fomat(prix_ttc);
		calcul_prix_ht();
	}

	public void calcul_prix_ht() {
		float v_tva = (float) tva / 100;
		float v_remise = (float) remise / 100;
		float prix_htva = (float) prix_ttc / ((float) 1 + v_tva);
		prix_ht = (float) prix_htva / ((float) 1 + v_remise);
		prix_ht = fomat(prix_ht);
	}

	public void calcul_prix_ttc() {
		float p_remise = (float) prix_ht * ((float) remise / 100);
		float prix_htva = prix_ht - p_remise;
		float p_tva = (float) prix_htva * ((float) tva / 100);
		prix_ttc = prix_htva + p_tva;
		prix_ttc = fomat(prix_ttc);
	}

	public float getTotalBrute() { // prix brut sans TVA et sans Remise

		return prix_ht * getQte();
	}

	public float getPrix_total_ttc() { // prix brut TTC

		return fomat(prix_ttc * getQte());
	}

	public void setPrix_total_ttc(float prix_total_ttc) {
		setPrix_ttc((float) prix_total_ttc / getQte());
	}

	public float getPrix_total_HTVA() {
		float p_remise = (float) prix_ht * ((float) remise / 100);
		return fomat((prix_ht - p_remise) * getQte());
	}

	private float fomat(float f) {
		int x = (int) (f * 1000);
		float t = (float) x / 1000;
		return t;
	}
	
}
