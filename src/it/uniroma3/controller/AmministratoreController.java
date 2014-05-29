package it.uniroma3.controller;

import java.util.List;
import it.uniroma3.model.*;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean
public class AmministratoreController {
	
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String cognome;
	private String nome;
	private String mail;
	private int password;
	private Amministratore amministratore;
	private List<Amministratore> amministratori;
	
	@EJB
	private AmministratoreFacade aFacade;
	
	public String createAmministratore() {
		this.amministratore = aFacade.createAmministratore(nome, cognome, mail, password);
		return "amministratore"; 
	}
	
	public String listAmministratori() {
		this.amministratori = aFacade.getAllAmministratori();
		return "Amministratori"; 
	}

	public String findAmministratore() {
		this.amministratore = aFacade.getAmministratore(id);
		return "Amministratore";
	}
	
	public String findAmministratore(Long id) {
		this.amministratore = aFacade.getAmministratore(id);
		return "Amministratore";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public Amministratore getAmministratore() {
		return amministratore;
	}

	public void setAmministratore(Amministratore amministratore) {
		this.amministratore = amministratore;
	}

	public List<Amministratore> getAmministratori() {
		return amministratori;
	}

	public void setAmministratori(List<Amministratore> amministratori) {
		this.amministratori = amministratori;
	}

	public AmministratoreFacade getaFacade() {
		return aFacade;
	}

	public void setaFacade(AmministratoreFacade aFacade) {
		this.aFacade = aFacade;
	}
	
}
