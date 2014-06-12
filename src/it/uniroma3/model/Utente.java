package it.uniroma3.model;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Column;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "TrovaTuttiGliUtenti", query = "SELECT u FROM Utente u")
public class Utente {
	
	@Column(nullable = false)
	private String cognome;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private Date dataDiNascita;
	@Column(nullable = false)
	private Date dataDiRegistrazione;
	@Column(nullable = false)
	private String indirizzo;
	@Column(nullable = false)
	private String mail;
	@Column(nullable = false)
	private String password;
	@OneToMany(mappedBy = "utente")
	private List<Ordine> ordini;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	public Utente(String nome, String cognome, Date dataDiNascita, Date dataDiRegistrazione, String indirizzo, String mail,
			String password) {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Ordine> getOrdini() {
		return ordini;
	}

	public void setOrdini(List<Ordine> ordini) {
		this.ordini = ordini;
	}
	
	public void addOrdine(Ordine o){
		this.ordini.add(o);
	}

	public long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result
				+ ((dataDiNascita == null) ? 0 : dataDiNascita.hashCode());
		result = prime
				* result
				+ ((dataDiRegistrazione == null) ? 0 : dataDiRegistrazione
						.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((indirizzo == null) ? 0 : indirizzo.hashCode());
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utente other = (Utente) obj;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (dataDiNascita == null) {
			if (other.dataDiNascita != null)
				return false;
		} else if (!dataDiNascita.equals(other.dataDiNascita))
			return false;
		if (dataDiRegistrazione == null) {
			if (other.dataDiRegistrazione != null)
				return false;
		} else if (!dataDiRegistrazione.equals(other.dataDiRegistrazione))
			return false;
		if (id != other.id)
			return false;
		if (indirizzo == null) {
			if (other.indirizzo != null)
				return false;
		} else if (!indirizzo.equals(other.indirizzo))
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (password != other.password)
			return false;
		return true;
	}

	
}
