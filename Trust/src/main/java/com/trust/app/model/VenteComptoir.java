package com.trust.app.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.CascadeType;
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
@Table(name = "VenteComptoir")
@ManagedBean(name = "venteComptoir")
@Data
public class VenteComptoir implements Document {


	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "datefacture")
	Date heur;

	@Column(name = "total_ttc")
	float total_ttc;

	@Column(name = "Payee")
	boolean Payee;

	@Column(name = "note")
	String note;

	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "VenteComptoir_id")
	private List<LigneVenteComptoir> listeligneVenteComptoir;

	public void addLigne(LigneVenteComptoir ligneVenteComptoir) {
		listeligneVenteComptoir.add(ligneVenteComptoir);
	}

	public float getTotalPrixMini() {
		if (listeligneVenteComptoir == null)
			return 0;
		float total = 0;

		for (int i = 0; i <= listeligneVenteComptoir.size() - 1; i++) {
			total += listeligneVenteComptoir.get(i).getTotalPrixMini();
		}
		return arrondir(total);

	}

	public float getTotalGain() {
		return arrondir(getTotalPrixTTC() - getTotalPrixMini());
	}

	public float getTotalRemise() {
		return arrondir(getTotalPrixBrute() - getTotalPrixTTC());
	}

	public float getTotalPrixTTC() {
		if (listeligneVenteComptoir == null)
			return 0;

		float total = 0;

		for (int i = 0; i <= listeligneVenteComptoir.size() - 1; i++) {
			total += listeligneVenteComptoir.get(i).getTotalPrixTTC();
		}

		return arrondir(total);
	}

	public float getTotalPrixBrute() {
		if (listeligneVenteComptoir == null)
			return 0;

		float total = 0;

		for (int i = 0; i <= listeligneVenteComptoir.size() - 1; i++) {
			total += listeligneVenteComptoir.get(i).getTotalPrixBrut();
		}

		return arrondir(total);
	}

	public float getTotalPrixDeclaree() {
		if (listeligneVenteComptoir == null)
			return 0;

		float total = 0;

		for (int i = 0; i <= listeligneVenteComptoir.size() - 1; i++) {
			total += listeligneVenteComptoir.get(i).getTotalPrixDeclaree();
		}

		return arrondir(total);
	}

	public void setTotalPrixTTC(float totalTTC) {

		Iterator<LigneVenteComptoir> iterator1 = listeligneVenteComptoir.iterator();
		while (iterator1.hasNext()) {
			LigneVenteComptoir lbl = iterator1.next();
			lbl.setPrix_ttc(lbl.getArticle().getPrixvente());
		}

		if (totalTTC > getTotalPrixTTC()) {

			float remise = totalTTC / getTotalPrixTTC();

			Iterator<LigneVenteComptoir> iterator = listeligneVenteComptoir.iterator();
			while (iterator.hasNext()) {
				LigneVenteComptoir lbl = iterator.next();
				lbl.setPrix_ttc(arrondir(lbl.getPrix_ttc() * remise));
			}

		} else {
			if (getTotalPrixMini() < totalTTC) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "sss"));

				float verif = 1;

				while ((getTotalPrixTTC() > totalTTC) && (verif > 0.010)) {
					System.out.println("=====while==== ");
					float remise = totalTTC / getTotalPrixTTC();
					Iterator<LigneVenteComptoir> iterator = listeligneVenteComptoir.iterator();
					verif = 0;
					while (iterator.hasNext()) {
						LigneVenteComptoir lbl = iterator.next();
						if (arrondir(lbl.getPrix_ttc() * remise) > arrondir(lbl.getArticle().getPrixmini())) {

							System.out.println("lbl.getPrix_ttc() * remise= " + arrondir(lbl.getPrix_ttc() * remise));
							System.out.println(
									"lbl.getArticle().getPrixmini()= " + arrondir(lbl.getArticle().getPrixmini()));

							lbl.setPrix_ttc(arrondir(lbl.getPrix_ttc() * remise));

						} else {
							System.out.println("====AAAAA====");
						}

					}
					verif = arrondir(getTotalPrixTTC() - totalTTC);
					System.out.println("verif= " + verif);
				}

				float tt = 0;
				int j = 0;

				for (int i = 0; i <= listeligneVenteComptoir.size() - 1; i++) {
					float yy = listeligneVenteComptoir.get(i).getPrix_ttc()
							- listeligneVenteComptoir.get(i).getArticle().getPrixmini();

					if (yy > tt) {
						j = i;
						yy = tt;
					}

				}
				listeligneVenteComptoir.get(j).setPrix_ttc(arrondir(listeligneVenteComptoir.get(j).getPrix_ttc()
						- (verif / listeligneVenteComptoir.get(j).getQte())));
				boolean verif2 = true;
				for (int i = 0; i <= listeligneVenteComptoir.size() - 1; i++) {
					if (verif2) {
						if (listeligneVenteComptoir.get(i).getQte() == 1) {
							listeligneVenteComptoir.get(i).setPrix_ttc(
									listeligneVenteComptoir.get(i).getTotalPrixTTC() + (totalTTC - getTotalPrixTTC()));
						}
					}

				}

			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", "sss"));
			}
		}

	}

	public void setRemise(float remise) {

		float r = remise / 100;

		float rr = getTotalPrixBrute() * r;

		setTotalPrixTTC(getTotalPrixBrute() - rr);

	}

	public float getRemise() {

		float x = ((getTotalPrixBrute() - getTotalPrixTTC()) / getTotalPrixBrute()) * 100;

		System.out.println("x= " + x);
		return arrondir(x);
	}

	private float arrondir(float nombre) {
		return (float) ((float) ((int) (nombre * Math.pow(10, 3) + .5)) / Math.pow(10, 3));
	}

	public List<LigneVenteComptoir> getListeligneVenteComptoirNoir() {

		List<LigneVenteComptoir> liste=new ArrayList<LigneVenteComptoir>();

		Iterator<LigneVenteComptoir> iterator = listeligneVenteComptoir.iterator();
		while (iterator.hasNext()) {
			LigneVenteComptoir lignevente = iterator.next();
			if (lignevente.black == true) {
				liste.add(lignevente);
			}

		}

		return liste;
	}
	public List<LigneVenteComptoir> getListeligneVenteComptoirDeclarer() {

		List<LigneVenteComptoir> liste=new ArrayList<LigneVenteComptoir>();

		Iterator<LigneVenteComptoir> iterator = listeligneVenteComptoir.iterator();
		while (iterator.hasNext()) {
			LigneVenteComptoir lignevente = iterator.next();
			if (lignevente.black == false) {
				liste.add(lignevente);
			}

		}

		return liste;
	}

	public List<LigneVenteComptoir>  getListeligneVenteComptoirSuspens() {

		List<LigneVenteComptoir> liste=new ArrayList<LigneVenteComptoir>();

		Iterator<LigneVenteComptoir> iterator = listeligneVenteComptoir.iterator();
		while (iterator.hasNext()) {
			LigneVenteComptoir lignevente = iterator.next();
			if (lignevente.valider == false) {
				liste.add(lignevente);
			}

		}

		return liste;
	}

}
