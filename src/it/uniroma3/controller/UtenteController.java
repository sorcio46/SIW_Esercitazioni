package it.uniroma3.controller;

import java.util.Date;
import java.util.List;

import it.uniroma3.model.Utente;
import it.uniroma3.model.UtenteFacade;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean
public class UtenteController {
	
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String nome;
	private String cognome;
	private String indirizzo;
	private String mail;
	private Date dataDiNascita;
	private Date dataDiRegistrazione;
	private String password;
	private Utente utente;
	private Utente corrente;
	private List<Utente> utenti;
	private String errore;
	
	@EJB
	private UtenteFacade utenteFacade;
	
	public String createUtente() {
		this.utente = utenteFacade.createUtente(nome, cognome, dataDiNascita, dataDiRegistrazione, indirizzo, mail, password);
		return "utente"; 
	}
	
	public String loginUtente(){
		this.utenti = utenteFacade.getAllUtenti();
		for(Utente u: utenti){
			if(mail.equals(u.getMail()))
				if(password.equals(u.getPassword())){
					this.corrente = u;
					this.errore = null;
					return "index";
				}
				else{
					this.errore="Mail o Password errati";
				}
			else{
				this.errore="Mail o Password errati";
			}
		}
		return "index";
	}
	
	public String logoutUtente(){
		this.corrente=null;
		return "index";
	}
	
	public Utente getCorrente() {
		return corrente;
	}

	public void setCorrente(Utente corrente) {
		this.corrente = corrente;
	}

	
	public String listUtenti() {
		this.utenti = utenteFacade.getAllUtenti();
		return "utenti"; 
	}

	public String findUtente() {
		this.utente = utenteFacade.getUtente(id);
		return "utente";
	}
	
	public String findUtente(Long id) {
		this.utente = utenteFacade.getUtente(id);
		return "utente";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public Date getDataDiRegistrazione() {
		return dataDiRegistrazione;
	}

	public void setDataDiRegistrazione(Date dataDiRegistrazione) {
		this.dataDiRegistrazione = dataDiRegistrazione;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public List<Utente> getUtenti() {
		return utenti;
	}

	public void setUtenti(List<Utente> utenti) {
		this.utenti = utenti;
	}

	public UtenteFacade getUtenteFacade() {
		return utenteFacade;
	}

	public void setUtenteFacade(UtenteFacade utenteFacade) {
		this.utenteFacade = utenteFacade;
	}

	public String getErrore() {
		return errore;
	}

	public void setErrore(String errore) {
		this.errore = errore;
	}

	
}
	
