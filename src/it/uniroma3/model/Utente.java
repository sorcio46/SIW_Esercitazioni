package it.uniroma3.model;

import java.util.*;

public class Utente {
	private String cognome;
	private String nome;
	private Date dataDiNascita;
	private Date dataDiRegistrazione;
	private String indirizzo;
	private String mail;
	private int password;

	public Utente(String nome, String cognome, Date dataDiNascita, Date dataDiRegistrazione, String indirizzo, String mail,
			int password) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.dataDiRegistrazione = dataDiRegistrazione;
		this.indirizzo = indirizzo;
		this.mail = mail;
		this.password = password;

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

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}
}
