package it.uniroma3.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Column;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name="trovaTutteLeRigheOrdine", query="SELECT r from RigaOrdine r")
public class RigaOrdine {
	
	@OneToOne
	@Column(nullable=false)
	private Product prodotto;
	
	@Column(nullable=false)
	private int quantita;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private Ordine ordine;
	
	public RigaOrdine(Product p, int q){
		this.prodotto=p;
		this.quantita=q;
	}

	public Long getId() {
		return this.id;
	}
	
	public Product getProdotto() {
		return prodotto;
	}

	public void setProdotto(Product prodotto) {
		this.prodotto = prodotto;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public Ordine getOrdine() {
		return ordine;
	}

	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((prodotto == null) ? 0 : prodotto.hashCode());
		result = prime * result + quantita;
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
		RigaOrdine other = (RigaOrdine) obj;
		if (prodotto == null) {
			if (other.prodotto != null)
				return false;
		} else if (!prodotto.equals(other.prodotto))
			return false;
		if (quantita != other.quantita)
			return false;
		return true;
	}
	
}
