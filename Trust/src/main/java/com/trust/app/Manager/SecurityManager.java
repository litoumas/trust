package com.trust.app.Manager;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.trust.app.model.User;

@ManagedBean(name = "SecurityManager")
@ViewScoped

/**
 * <b>SecurityManager est la classe qui gère la permission d’accès au différent
 * page </b>
 * 
 * @see User
 * 
 * @author Amir Hamouda
 * @version 1.0
 */
public class SecurityManager  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8493447751770252350L;

	/**
	 * Vérifie si l’utilisateur a le droit d’accéder à la page si ce n’est pas le
	 * cas il seras rediriger ver la page d’accueil ou la page de connexion s’il
	 * n’est pas connecter
	 * 
	 */

	public String getVerifPermission() {
		// verifier si l'utilisateur est connecter
		if (getUser() == null) {
			// si il n'est pas connecter on le rederge ver la page de connexion
			RedirectManager.redirect(PathManager.PATH_LOGIN_PAGE);
		} else {
			// si il est connecter on verifie qu'il a bien le doit d'acceder a la page
			if (!getUser().hasPermissionToVisit(getRequestURL())) {// si il na pas le doit d'acceder a la page
				if (!getRequestURL().equals(PathManager.PATH_HOME_PAGE)) // on verifier qu'il n'est pas dans la Home
																			// Page
					RedirectManager.redirect(PathManager.PATH_HOME_PAGE);// et on le rederige ver la Home Page
			}

		}

		return "";
	}

	/**
	 * Récupère l’objet User de la session si elle existe
	 * 
	 * @return null si l'utilisateur n’est pas connecter si non User
	 */

	private User getUser() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		// verifier si l'utilisateur est connecter
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		if (sessionMap.get("User") != null)
			return (User) sessionMap.get("User");
		return null;
	}

	/**
	 * recupere l'addresse de la page acctuelle
	 * 
	 * @return l'addresse de la page acctuelle
	 */
	private String getRequestURL() {
		HttpServletRequest origRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		return origRequest.getRequestURI();
	}

	/**
	 * Vérifie si l’utilisateur a le droit d’accéder a une URL
	 * 
	 * @param url
	 * @return true si l’utilisateur a le droit d’accéder a l'url
	 */
	public boolean verifPermission(String url) {
		if (getUser() != null) { // On vérifie que l’utilisateur est bien connecté

			return getUser().hasPermissionToVisit(url);

		}
		return false;
	}

	public boolean gethasPermissionToSeeBlack() {
		if (getUser() != null) { // On vérifie que l’utilisateur est bien connecté

			return getUser().isSeeBlack();

		}
		return false;
	}

	public void logout() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.clear();
		RedirectManager.redirect(PathManager.PATH_LOGIN_PAGE);
		System.out.println("============Logout==============");
	}
}