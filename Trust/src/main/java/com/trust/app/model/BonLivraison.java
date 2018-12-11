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
	
	public float getTotalPrixMini() {
		if(ligneLivraisons==null)
			return 0;
		float total=0;
		
		for(int i=0;i<=ligneLivraisons.size()-1;i++)
		{
			total+=ligneLivraisons.get(i).getTotalPrixMini();
		}
		return arrondir(total);
		
	}
	
	public float getTotalGain() {
		return arrondir(getTotalPrixTTC()-getTotalPrixMini());
	}
	public float getTotalRemise() {
		return arrondir(getTotalPrixBrute()-getTotalPrixTTC());
	}
	
	
	public float getTotalPrixTTC()
	{
		if(ligneLivraisons==null)
			return 0;
		
		float total=0;
		
		for(int i=0;i<=ligneLivraisons.size()-1;i++)
		{
			total+=ligneLivraisons.get(i).getTotalPrixTTC();
		}
		
		return arrondir(total);
	}
	public float getTotalPrixBrute()
	{
		if(ligneLivraisons==null)
			return 0;
		
		float total=0;
		
		for(int i=0;i<=ligneLivraisons.size()-1;i++)
		{
			total+=ligneLivraisons.get(i).getTotalPrixBrut();
		}
		
		return arrondir(total);
	}
	public float getTotalPrixDeclaree()
	{
		if(ligneLivraisons==null)
			return 0;
		
		float total=0;
		
		for(int i=0;i<=ligneLivraisons.size()-1;i++)
		{
			total+=ligneLivraisons.get(i).getTotalPrixDeclaree();
		}
		
		return arrondir(total);
	}
	
	private float arrondir(float nombre) {
		return (float) ((float) ((int) (nombre * Math.pow(10, 3) + .5)) / Math.pow(10, 3));
	}
	
	public boolean setTotalPrixTTC(float totalTTC)
	{
		if(getTotalPrixMini()<totalTTC)
		{
			// To Do
			return true;
		}
		return false;
	}
	
}
