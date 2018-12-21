package com.trust.app.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.trust.app.manager.PathManager;
import com.trust.app.manager.RedirectManager;
import com.trust.app.model.Client;
import com.trust.app.model.Droit;
import com.trust.app.model.Exercice;
import com.trust.app.model.Parametre;
import com.trust.app.service.ClientService;
import com.trust.app.service.DroitService;
import com.trust.app.service.ExerciceService;
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
	
	

	@Getter
	@Setter
	@ManagedProperty("#{userService}")
	private UserService userService;

	@Getter
	@Setter
	@ManagedProperty("#{droitService}")
	private DroitService droitService;

	@Getter
	@Setter
	@ManagedProperty("#{parametreService}")
	private ParametreService parametreService;
	
	@Getter
	@Setter
	@ManagedProperty("#{clientService}")
	private ClientService clientService;
	
	@Getter
	@Setter
	@ManagedProperty("#{exerciceService}")
	private ExerciceService exerciceService;
	
	

	/**
	 * @throws ParseException 
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

	public String getControleall() throws ParseException { // verifie si tout les parametre sont disponible dans la BD si elle ne le sont
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
		if(parametreService.getParametre(Parametre.CODEFOURNISSEUR)==null)
		{
			Parametre parametre=new Parametre();
			parametre.setIdentifiant(Parametre.CODEFOURNISSEUR);
			parametre.setValeur(""+0);
			parametreService.addParametre(parametre);
		}
		if(parametreService.getParametre("prefix_"+Parametre.CODEFOURNISSEUR)==null)
		{
			Parametre parametre=new Parametre();
			parametre.setIdentifiant("prefix_"+Parametre.CODEFOURNISSEUR);
			parametre.setValeur("F");
			parametreService.addParametre(parametre);
		}
		if(parametreService.getParametre("suffixe_"+Parametre.CODEFOURNISSEUR)==null)
		{
			Parametre parametre=new Parametre();
			parametre.setIdentifiant("suffixe_"+Parametre.CODEFOURNISSEUR);
			parametre.setValeur("");
			parametreService.addParametre(parametre);
		}
		if(parametreService.getParametre("nbr0_"+Parametre.CODEFOURNISSEUR)==null)
		{
			Parametre parametre=new Parametre();
			parametre.setIdentifiant("nbr0_"+Parametre.CODEFOURNISSEUR);
			parametre.setValeur(""+5);
			parametreService.addParametre(parametre);
		}
		
		// ==== Parmetre code Client==== //
		
		if(parametreService.getParametre(Parametre.CODECLIENT)==null)
		{
			Parametre parametre=new Parametre();
			parametre.setIdentifiant(Parametre.CODECLIENT);
			parametre.setValeur(""+0);
			parametreService.addParametre(parametre);
		}
		if(parametreService.getParametre("prefix_"+Parametre.CODECLIENT)==null)
		{
			Parametre parametre=new Parametre();
			parametre.setIdentifiant("prefix_"+Parametre.CODECLIENT);
			parametre.setValeur("C");
			parametreService.addParametre(parametre);
		}
		if(parametreService.getParametre("suffixe_"+Parametre.CODECLIENT)==null)
		{
			Parametre parametre=new Parametre();
			parametre.setIdentifiant("suffixe_"+Parametre.CODECLIENT);
			parametre.setValeur("");
			parametreService.addParametre(parametre);
		}
		if(parametreService.getParametre("nbr0_"+Parametre.CODECLIENT)==null)
		{
			Parametre parametre=new Parametre();
			parametre.setIdentifiant("nbr0_"+Parametre.CODECLIENT);
			parametre.setValeur(""+5);
			parametreService.addParametre(parametre);
		}
		
	// ==== Parmetre code Client==== //
		
		if(parametreService.getParametre(Parametre.NUMEROBONRECEPTION)==null)
		{
			Parametre parametre=new Parametre();
			parametre.setIdentifiant(Parametre.NUMEROBONRECEPTION);
			parametre.setValeur(""+0);
			parametreService.addParametre(parametre);
		}
		if(parametreService.getParametre("prefix_"+Parametre.NUMEROBONRECEPTION)==null)
		{
			Parametre parametre=new Parametre();
			parametre.setIdentifiant("prefix_"+Parametre.NUMEROBONRECEPTION);
			parametre.setValeur("BR2019/");
			parametreService.addParametre(parametre);
		}
		if(parametreService.getParametre("suffixe_"+Parametre.NUMEROBONRECEPTION)==null)
		{
			Parametre parametre=new Parametre();
			parametre.setIdentifiant("suffixe_"+Parametre.NUMEROBONRECEPTION);
			parametre.setValeur("");
			parametreService.addParametre(parametre);
		}
		if(parametreService.getParametre("nbr0_"+Parametre.NUMEROBONRECEPTION)==null)
		{
			Parametre parametre=new Parametre();
			parametre.setIdentifiant("nbr0_"+Parametre.NUMEROBONRECEPTION);
			parametre.setValeur(""+5);
			parametreService.addParametre(parametre);
		}
		
		
		
		
		// verification du Client passager
		
		List<Client> listClient=clientService.listClients();
		if(listClient.size()==0)
		{
			Client client=new Client();
			client.setNom("Client Passager");
			client.setCode(getNextNumber(Parametre.CODECLIENT));
			clientService.addClient(client);
			
			
			Parametre par = parametreService.getParametre(Parametre.CODECLIENT);
			par.setValeur(""+(Integer.parseInt(par.getValeur())+1));
			parametreService.updateParametre(par);
			
		}
		
		// verification du % vente
		
		if(parametreService.getParametre(Parametre.PAR100SVENTEDECLARER)==null)
		{
			Parametre parametre=new Parametre();
			parametre.setIdentifiant(Parametre.PAR100SVENTEDECLARER);
			parametre.setValeur("10");
			parametreService.addParametre(parametre);
		}
		
		
		
		if(exerciceService.listExercices().size()==0)
		{
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			String date1 = "01/01/2019";
			Exercice exercice=new Exercice();
			Date  date = simpleDateFormat.parse(date1);
			
			exercice.setDate_debut(date);
			exerciceService.addExercice(exercice);
			
		}
		
		
		return null;
	}

	
	
	public String getNextNumber(String parametre) {

		int nbr0 = Integer.parseInt(parametreService.getParametre("nbr0_" + parametre).getValeur()); // nombre de chifre
																										// que comporte
																										// le numero
		String prefix = parametreService.getParametre("prefix_" + parametre).getValeur(); // prefix du nemero
		String suffixe = parametreService.getParametre("suffixe_" + parametre).getValeur(); // suffixe du nemero

		String numero = prefix;

		Parametre para = parametreService.getParametre(parametre);
		int num = Integer.parseInt(para.getValeur());
		num++;
		int nbr = String.valueOf(num).length(); // ici on utilise le ID a la place de nemero

		for (int i = 0; i <= (nbr0 - nbr) - 1; i++) // on ajoute les 0 manquant
		{
			numero += "0";
		}
		numero += num + suffixe; // ici on utilise le ID a la place de nemero

		para.setValeur("" + num);
		return numero;
	}
	
	
	

}
