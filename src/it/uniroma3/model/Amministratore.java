package it.uniroma3.model;


public class Amministratore {
	private String cognome;
	private String nome;
	private String mail;
	private int password;

	public Amministratore(String nome, String cognome, String mail,int password) {
		this.nome = nome;
		this.cognome = cognome;
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
