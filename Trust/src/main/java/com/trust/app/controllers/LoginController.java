package com.trust.app.controllers;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.primefaces.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.trust.app.Manager.PathManager;
import com.trust.app.Manager.RedirectManager;
import com.trust.app.model.User;

@ManagedBean(name = "LoginController")
@ViewScoped
public class LoginController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6654119169750565913L;

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	private String login;
	private String pass;
	private SessionFactory sessionFactory;

	// Initiation part
	@PostConstruct
	public void init() {


	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	public String login() {

	
		
		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage message = null;
		boolean loggedIn = false;
		String userName = "";
		Session session = this.sessionFactory.openSession();

		Criteria cr = session.createCriteria(User.class);
		Criterion salary = Restrictions.eq("login", login);

		 String generatedHash = DigestUtils.md5Hex(pass);
		//
		// Criterion name = Restrictions.eq("passhash",generatedHash);

		Criterion name = Restrictions.eq("passhash", generatedHash);
		LogicalExpression andExp = Restrictions.and(salary, name);
		cr.add(andExp);

		@SuppressWarnings("unchecked")
		List<User> usersList = cr.list();
		if (usersList.size() > 0) {
			User u = usersList.get(0);
			loggedIn = true;
			userName = u.getName();

			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			Map<String, Object> sessionMap = externalContext.getSessionMap();
			sessionMap.put("User", u);

		}
		if (loggedIn) {
			logger.info("First matching user logged in ::" + userName);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome: " + userName, null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			context.addCallbackParam("loggedIn", loggedIn);

			
			RedirectManager.redirect(PathManager.PATH_HOME_PAGE);

			
			return "/views/pages/home";
		} else {
			logger.info("Wrong password or login");
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Wrong password or login");
			FacesContext.getCurrentInstance().addMessage(null, message);
			context.addCallbackParam("loggedIn", loggedIn);
			return "login";
		}
	}

}
