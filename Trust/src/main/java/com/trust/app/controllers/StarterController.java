package com.trust.app.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.trust.app.Manager.PathManager;
import com.trust.app.Manager.RedirectManager;
import com.trust.app.model.Droit;
import com.trust.app.model.Parametre;
import com.trust.app.service.DroitService;
import com.trust.app.service.ParametreService;
import com.trust.app.service.UserService;

import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "StarterController")
@ViewScoped
public class StarterController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7690233183716547910L;
	
	
	@ManagedProperty("#{userService}")
	@Getter
	@Setter
	private UserService userService;
	
	
	@ManagedProperty("#{droitService}")
	@Getter
	@Setter
	private DroitService droitService;
	
	@ManagedProperty("#{parametreService}")
	@Getter
	@Setter
	private ParametreService parametreService;
	
	

	/**
	 * @PostConstruct public void init() {
	 *                System.out.println("=========================================================");
	 *                System.out.println("=========================================================");
	 *                System.out.println("=========================================================");
	 *                System.out.println("=========================================================");
	 *                System.out.println("=========================================================");
	 * 
	 * 
	 *                System.out.println("=========================================================");
	 *                System.out.println("=========================================================");
	 *                System.out.println("=========================================================");
	 *                System.out.println("=========================================================");
	 *                System.out.println("=========================================================");
	 * 
	 *                }
	 **/

	public String getControleall() { // verifie si tout les parametre sont disponible dans la BD si elle ne le sont
										// pas elle rederige l'utilisateur vere la page de parametrage

	
		
		
		
		
		if (userService.listUsers().size() == 0) {
			
			
			RedirectManager.redirect(PathManager.PATH_NEWUSER_PAGE);
		} 
		
		List<String> pathlist = PathManager.getPathListe();
		if (droitService.listDroits().size() == 0) {
			for (int i = 0; i <= pathlist.size() - 1; i++) {
				Droit droit = new Droit();
				droit.setPath(pathlist.get(i));
				droitService.addDroit(droit);
			}
		}
		
		
		// verification des parametre est les crée si besoin
		
		// ==== Parmetre code Fournisseur==== //
		if(parametreService.getParametre("codeFournisseur")==null)
		{
			Parametre parametre=new Parametre();
			parametre.setIdentifiant("codeFournisseur");
			parametre.setValeur(""+0);
			parametreService.addParametre(parametre);
		}
		if(parametreService.getParametre("prefix_codeFournisseur")==null)
		{
			Parametre parametre=new Parametre();
			parametre.setIdentifiant("prefix_codeFournisseur");
			parametre.setValeur("F");
			parametreService.addParametre(parametre);
		}
		if(parametreService.getParametre("suffixe_codeFournisseur")==null)
		{
			Parametre parametre=new Parametre();
			parametre.setIdentifiant("suffixe_codeFournisseur");
			parametre.setValeur("");
			parametreService.addParametre(parametre);
		}
		if(parametreService.getParametre("nbr0_codeFournisseur")==null)
		{
			Parametre parametre=new Parametre();
			parametre.setIdentifiant("nbr0_codeFournisseur");
			parametre.setValeur(""+5);
			parametreService.addParametre(parametre);
		}
		
		// ==== Parmetre code Client==== //
		
		if(parametreService.getParametre("codeClient")==null)
		{
			Parametre parametre=new Parametre();
			parametre.setIdentifiant("codeClient");
			parametre.setValeur(""+0);
			parametreService.addParametre(parametre);
		}
		if(parametreService.getParametre("prefix_codeClient")==null)
		{
			Parametre parametre=new Parametre();
			parametre.setIdentifiant("prefix_codeClient");
			parametre.setValeur("C");
			parametreService.addParametre(parametre);
		}
		if(parametreService.getParametre("suffixe_codeClient")==null)
		{
			Parametre parametre=new Parametre();
			parametre.setIdentifiant("suffixe_codeClient");
			parametre.setValeur("");
			parametreService.addParametre(parametre);
		}
		if(parametreService.getParametre("nbr0_codeClient")==null)
		{
			Parametre parametre=new Parametre();
			parametre.setIdentifiant("nbr0_codeClient");
			parametre.setValeur(""+5);
			parametreService.addParametre(parametre);
		}
		
	// ==== Parmetre code Client==== //
		
		if(parametreService.getParametre("numeroBonReception")==null)
		{
			Parametre parametre=new Parametre();
			parametre.setIdentifiant("numeroBonReception");
			parametre.setValeur(""+0);
			parametreService.addParametre(parametre);
		}
		if(parametreService.getParametre("prefix_numeroBonReception")==null)
		{
			Parametre parametre=new Parametre();
			parametre.setIdentifiant("prefix_numeroBonReception");
			parametre.setValeur("BR2019/");
			parametreService.addParametre(parametre);
		}
		if(parametreService.getParametre("suffixe_numeroBonReception")==null)
		{
			Parametre parametre=new Parametre();
			parametre.setIdentifiant("suffixe_numeroBonReception");
			parametre.setValeur("");
			parametreService.addParametre(parametre);
		}
		if(parametreService.getParametre("nbr0_numeroBonReception")==null)
		{
			Parametre parametre=new Parametre();
			parametre.setIdentifiant("nbr0_codeClient");
			parametre.setValeur(""+5);
			parametreService.addParametre(parametre);
		}
		
		
		
		
		
		
		return null;
	}

	
	
	
	
	
	

}
