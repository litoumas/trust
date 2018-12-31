package com.trust.app.model;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "BONLIVRAISON")
@ManagedBean(name = "BonLivraison")
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

	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "BonLivraison_id")
	private List<LigneLivraison> ligneLivraisons;

	public void addLigne(LigneLivraison ligneLivraison) {
		ligneLivraisons.add(ligneLivraison);
	}

	public float getTotalPrixMini() {
		if (ligneLivraisons == null)
			return 0;
		float total = 0;

		for (int i = 0; i <= ligneLivraisons.size() - 1; i++) {
			total += ligneLivraisons.get(i).getTotalPrixMini();
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
		if (ligneLivraisons == null)
			return 0;

		float total = 0;

		for (int i = 0; i <= ligneLivraisons.size() - 1; i++) {
			total += ligneLivraisons.get(i).getTotalPrixTTC();
		}

		return arrondir(total);
	}

	public float getTotalPrixBrute() {
		if (ligneLivraisons == null)
			return 0;

		float total = 0;

		for (int i = 0; i <= ligneLivraisons.size() - 1; i++) {
			total += ligneLivraisons.get(i).getTotalPrixBrut();
		}

		return arrondir(total);
	}

	public float getTotalPrixDeclaree() {
		if (ligneLivraisons == null)
			return 0;

		float total = 0;

		for (int i = 0; i <= ligneLivraisons.size() - 1; i++) {
			total += ligneLivraisons.get(i).getTotalPrixDeclaree();
		}

		return arrondir(total);
	}

	public void setTotalPrixTTC(float totalTTC) {

		Iterator<LigneLivraison> iterator1 = ligneLivraisons.iterator();
		while (iterator1.hasNext()) {
			LigneLivraison lbl = iterator1.next();
			lbl.setPrix_ttc(lbl.getArticle().getPrixvente());
		}
		
		if (totalTTC > getTotalPrixTTC()) {
		
			float remise = totalTTC / getTotalPrixTTC();
			
			Iterator<LigneLivraison> iterator = ligneLivraisons.iterator();
			while (iterator.hasNext()) {
				LigneLivraison lbl = iterator.next();
				lbl.setPrix_ttc(arrondir(lbl.getPrix_ttc() * remise));
			}
			
			
			
		} else {
			if (getTotalPrixMini() < totalTTC) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "sss"));
				
				float verif=1;
				
				while ((getTotalPrixTTC() > totalTTC)&&(verif>0.010)) {
					System.out.println("=====while==== ");
					float remise = totalTTC / getTotalPrixTTC();
					Iterator<LigneLivraison> iterator = ligneLivraisons.iterator();
					 verif=0;
					while (iterator.hasNext()) {
						LigneLivraison lbl = iterator.next();
						if (arrondir(lbl.getPrix_ttc() * remise) > arrondir(lbl.getArticle().getPrixmini())) {
							
							System.out.println("lbl.getPrix_ttc() * remise= " + arrondir(lbl.getPrix_ttc() * remise));
							System.out.println("lbl.getArticle().getPrixmini()= " + arrondir(lbl.getArticle().getPrixmini()));
							
							lbl.setPrix_ttc(arrondir(lbl.getPrix_ttc() * remise));
							
							
							
						}else
						{
							System.out.println("====AAAAA====");
						}

						
						
						
					}
					verif=arrondir(getTotalPrixTTC()-totalTTC);
					System.out.println("verif= " +verif);
				}
				
				float tt=0;
				int j=0;
				
				for (int i = 0; i <= ligneLivraisons.size() - 1; i++) {
					float yy=	ligneLivraisons.get(i).getPrix_ttc()-ligneLivraisons.get(i).getArticle().getPrixmini();
					
					if(yy>tt)
					{
						j=i;
						yy=tt;
					}
					
				}
				ligneLivraisons.get(j).setPrix_ttc(arrondir(ligneLivraisons.get(j).getPrix_ttc()-(verif/ligneLivraisons.get(j).getQte())));
				boolean verif2=true;
				for (int i = 0; i <= ligneLivraisons.size() - 1; i++) {
					if(verif2)
					{
						if(ligneLivraisons.get(i).getQte()==1)
						{
							ligneLivraisons.get(i).setPrix_ttc(ligneLivraisons.get(i).getTotalPrixTTC()+(totalTTC-getTotalPrixTTC()));
						}
					}
					
				}
				
				
			}else
			{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", "sss"));
			}
		}


	}

	public void setRemise(float remise) {

		float r=remise/100;
		
		float rr= getTotalPrixBrute()*r;
		
		setTotalPrixTTC(getTotalPrixBrute()-rr);
		
		
	}

	public float getRemise() {

	float x=	((getTotalPrixBrute()-getTotalPrixTTC())/getTotalPrixBrute())*100;
		
	System.out.println("x= " +x);
		return arrondir(x);
	}

	private float arrondir(float nombre) {
		return (float) ((float) ((int) (nombre * Math.pow(10, 3) + .5)) / Math.pow(10, 3));
	}

}