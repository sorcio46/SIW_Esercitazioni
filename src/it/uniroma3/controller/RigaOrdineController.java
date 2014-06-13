package it.uniroma3.controller;

import java.util.List;
import it.uniroma3.model.*;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean
public class RigaOrdineController {
	
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private Long pid;
	private Product prodotto;
	private int quantita;
	private RigaOrdine rigaordine;
	private List<RigaOrdine> righeordini;
	
	@EJB
	private RigaOrdineFacade rFacade;
	@EJB
	private ProductFacade pFacade;
	
	public String creaRigaOrdine(){
		this.prodotto = this.pFacade.getProduct(pid);
		this.rigaordine = this.rFacade.createRigaOrdine(prodotto, quantita);
		return "creaOrdine"; 
	}
	
	public String listrigheordini() {
		this.righeordini = rFacade.getAllRigheOrdine();
		return "RigheOrdini"; 
	}

	public String findrigaordine() {
		this.rigaordine = rFacade.getRigaOrdine(id);
		return "RigaOrdine";
	}
	
	public String findrigaordine(Long id) {
		this.rigaordine = rFacade.getRigaOrdine(id);
		return "RigaOrdine";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public RigaOrdine getRigaordine() {
		return rigaordine;
	}

	public void setRigaordine(RigaOrdine rigaordine) {
		this.rigaordine = rigaordine;
	}

	public List<RigaOrdine> getRigheordini() {
		return righeordini;
	}

	public void setRigheordini(List<RigaOrdine> righeordini) {
		this.righeordini = righeordini;
	}

	public RigaOrdineFacade getrFacade() {
		return rFacade;
	}

	public void setrFacade(RigaOrdineFacade rFacade) {
		this.rFacade = rFacade;
	}

}
