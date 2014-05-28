package it.uniroma3.model;


public class Fornitore {
	private String nome;
	private String partitaIVA;
	private String indirizzo;

	public Fornitore(String nome, String partitaIVA, String indirizzo) {
		this.nome = nome;
		this.setIndirizzo(indirizzo);
		this.setPartitaIVA(partitaIVA);

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPartitaIVA() {
		return partitaIVA;
	}

	public void setPartitaIVA(String partitaIVA) {
		this.partitaIVA = partitaIVA;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((indirizzo == null) ? 0 : indirizzo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((partitaIVA == null) ? 0 : partitaIVA.hashCode());
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
		Fornitore other = (Fornitore) obj;
		if (indirizzo == null) {
			if (other.indirizzo != null)
				return false;
		} else if (!indirizzo.equals(other.indirizzo))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (partitaIVA == null) {
			if (other.partitaIVA != null)
				return false;
		} else if (!partitaIVA.equals(other.partitaIVA))
			return false;
		return true;
	}

}
