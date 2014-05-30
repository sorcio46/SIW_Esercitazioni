package it.uniroma3.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.uniroma3.model.Ordine;
import it.uniroma3.model.OrdineFacade;
import it.uniroma3.model.RigaOrdine;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

	@ManagedBean
	public class OrdineController {
		
		@ManagedProperty(value="#{param.id}")
		private Ordine ordine;
		private List<Ordine> ordini;
		private List<RigaOrdine> rigaOrdine = new ArrayList<RigaOrdine>();
		private Long codice;
		private Date dataAperturaOrdine;
		private Date dataChiusuraOrdine;
		private Date dataEvasioneOrdine;
		private double totale;
		
		
		@EJB
		private OrdineFacade ordineFacade;
		
		
		public String createOrdine() {
			this.ordine = ordineFacade.createOrdine(rigaOrdine, dataAperturaOrdine, dataChiusuraOrdine, dataEvasioneOrdine, totale);
			return "ordine"; 
		}
		
		public String listOrdini() {
			this.ordini = ordineFacade.getAllOrdini();
			return "ordini"; 
		}

		public String findOrdine() {
			this.ordine = ordineFacade.getOrdine(codice);
			return "ordine";
		}
		
		public String findOrdine(Long codice) {
			this.ordine = ordineFacade.getOrdine(codice);
			return "ordine";
		}

		public Ordine getOrdine() {
			return ordine;
		}

		public void setOrdine(Ordine ordine) {
			this.ordine = ordine;
		}

		public List<Ordine> getOrdini() {
			return ordini;
		}

		public void setOrdini(List<Ordine> ordini) {
			this.ordini = ordini;
		}

		public List<RigaOrdine> getRigaOrdine() {
			return rigaOrdine;
		}

		public void setRigaOrdine(List<RigaOrdine> rigaOrdine) {
			this.rigaOrdine = rigaOrdine;
		}

		public Long getCodice() {
			return codice;
		}

		public void setCodice(Long codice) {
			this.codice = codice;
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

		public OrdineFacade getOrdineFacade() {
			return ordineFacade;
		}

		public void setOrdineFacade(OrdineFacade ordineFacade) {
			this.ordineFacade = ordineFacade;
		}
		
	}