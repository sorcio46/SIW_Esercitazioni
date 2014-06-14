package it.uniroma3.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "TrovaTuttiGliOrdini", query = "SELECT o FROM Ordine o")

public class Ordine {
	@Column(nullable = false)
	@OneToMany(mappedBy = "ordine")
	private List<RigaOrdine> righeOrdine = new ArrayList<RigaOrdine>();
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private Date dataAperturaOrdine;
	@Column(nullable = false)
	private Date dataChiusuraOrdine;
	@Column(nullable = false)
	private Date dataEvasioneOrdine;
	@Column(nullable = false)
	private double totale;
	
	@ManyToOne
	private Utente utente;
	
	public Ordine(List<RigaOrdine> righeOrdine, Date dataAperturaOrdine, Date dataChiusuraOrdine, Date dataEvasioneOrdine, double totale, Utente u){
		this.dataAperturaOrdine = dataAperturaOrdine;
		this.dataChiusuraOrdine = dataChiusuraOrdine;
		this.dataEvasioneOrdine = dataEvasioneOrdine;
		this.righeOrdine = righeOrdine;
		this.totale = totale;
		this.utente = u;
	}

	public List<RigaOrdine> getRigheOrdine() {
		return righeOrdine;
	}

	public void setRigheOrdine(List<RigaOrdine> righeOrdine) {
		this.righeOrdine = righeOrdine;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataAperturaOrdine() {
		return dataAperturaOrdine;
	}

	public void setDataAperturaOrdine(Date dataAperturaOrdine) {
		this.dataAperturaOrdine = dataAperturaOrdine;
	}

	public Date getDataChiusuraOrdine() {
		return dataChiusuraOrdine;
	}

	public void setDataChiusuraOrdine(Date dataChiusuraOrdine) {
		this.dataChiusuraOrdine = dataChiusuraOrdine;
	}

	public Date getDataEvasioneOrdine() {
		return dataEvasioneOrdine;
	}

	public void setDataEvasioneOrdine(Date dataEvasioneOrdine) {
		this.dataEvasioneOrdine = dataEvasioneOrdine;
	}

	public double getTotale() {
		return totale;
	}

	public void setTotale(double totale) {
		this.totale = totale;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((dataAperturaOrdine == null) ? 0 : dataAperturaOrdine
						.hashCode());
		result = prime
				* result
				+ ((dataChiusuraOrdine == null) ? 0 : dataChiusuraOrdine
						.hashCode());
		result = prime
				* result
				+ ((dataEvasioneOrdine == null) ? 0 : dataEvasioneOrdine
						.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((righeOrdine == null) ? 0 : righeOrdine.hashCode());
		long temp;
		temp = Double.doubleToLongBits(totale);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((utente == null) ? 0 : utente.hashCode());
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
		Ordine other = (Ordine) obj;
		if (dataAperturaOrdine == null) {
			if (other.dataAperturaOrdine != null)
				return false;
		} else if (!dataAperturaOrdine.equals(other.dataAperturaOrdine))
			return false;
		if (dataChiusuraOrdine == null) {
			if (other.dataChiusuraOrdine != null)
				return false;
		} else if (!dataChiusuraOrdine.equals(other.dataChiusuraOrdine))
			return false;
		if (dataEvasioneOrdine == null) {
			if (other.dataEvasioneOrdine != null)
				return false;
		} else if (!dataEvasioneOrdine.equals(other.dataEvasioneOrdine))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (righeOrdine == null) {
			if (other.righeOrdine != null)
				return false;
		} else if (!righeOrdine.equals(other.righeOrdine))
			return false;
		if (Double.doubleToLongBits(totale) != Double
				.doubleToLongBits(other.totale))
			return false;
		if (utente == null) {
			if (other.utente != null)
				return false;
		} else if (!utente.equals(other.utente))
			return false;
		return true;
	}

}
