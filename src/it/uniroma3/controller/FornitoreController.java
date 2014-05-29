package it.uniroma3.controller;

import java.util.List;

import it.uniroma3.model.Fornitore;
import it.uniroma3.model.FornitoreFacade;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;


	@ManagedBean
	public class FornitoreController {
		
		@ManagedProperty(value="#{param.id}")
		private String nome;
		private String partitaIVA;
		private String indirizzo;
		private long id;
		private Fornitore fornitore;
		private List<Fornitore> fornitori;
		
		
		@EJB
		private FornitoreFacade fornitoreFacade;
		
		
		public String createFornitore() {
			this.fornitore = fornitoreFacade.createFornitore(nome, partitaIVA, indirizzo);
			return "fornitore"; 
		}
		
		public String listFornitori() {
			this.fornitori = fornitoreFacade.getAllFornitori();
			return "fornitori"; 
		}

		public String findfornitore() {
			this.fornitore = fornitoreFacade.getFornitore(id);
			return "fornitore";
		}
		
		public String findfornitore(Long id) {
			this.fornitore = fornitoreFacade.getFornitore(id);
			return "fornitore";
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

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public Fornitore getFornitore() {
			return fornitore;
		}

		public void setFornitore(Fornitore fornitore) {
			this.fornitore = fornitore;
		}

		public List<Fornitore> getFornitori() {
			return fornitori;
		}

		public void setFornitori(List<Fornitore> fornitori) {
			this.fornitori = fornitori;
		}

		public FornitoreFacade getFornitoreFacade() {
			return fornitoreFacade;
		}

		public void setFornitoreFacade(FornitoreFacade fornitoreFacade) {
			this.fornitoreFacade = fornitoreFacade;
		}
}
