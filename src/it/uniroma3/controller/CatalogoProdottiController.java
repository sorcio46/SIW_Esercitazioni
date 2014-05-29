package it.uniroma3.controller;

import java.util.ArrayList;
import java.util.List;
import it.uniroma3.model.*;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean
public class CatalogoProdottiController {
	
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private List<Product> prodotti = new ArrayList<Product>();
	private CatalogoProdotti c;
	private List<CatalogoProdotti> cl; //inutile

	@EJB
	private CatalogoProdottiFacade cFacade;
	
	public String createCatalogoProdotti() {
		this.c = cFacade.createCatalogoProdotti();
		return "CatalogoProdotti"; 
	}
	
	public String listAmministratori() {
		//non c'è il metodo per il get della lista
		return "CataloghiProdotti"; 
	}

	public String findCatalogoProdotti() {
		this.c = cFacade.getCatalogoProdotti(id);
		return "CatalogoProdotti";
	}
	
	public String findCatalogoProdotti(Long id) {
		this.c = cFacade.getCatalogoProdotti(id);
		return "CatalogoProdotti";
	}

	public Long getId(){
		return this.id;
	}
	
	public List<Product> getProducts(){
		return this.prodotti;
	}
	
	public void addProduct(Product c){
		this.prodotti.add(c);
	}
	
	public void removeProduct(Product c){
		this.prodotti.remove(c);
	}
	
	public Product getProduct(Long id){
		for(Product z:this.prodotti){
			if(z.getId()==id)
				return z;
		}
		return null;
	}
	
	public void updateProduct(Product c){
		for(Product z:this.prodotti){
			if(z.getId()==c.getId())
				z=c;
		}
	}
	
	public List<Product> getProdotti() {
		return prodotti;
	}

	public void setProdotti(List<Product> prodotti) {
		this.prodotti = prodotti;
	}

	public CatalogoProdotti getC() {
		return c;
	}

	public void setC(CatalogoProdotti c) {
		this.c = c;
	}

	public List<CatalogoProdotti> getCl() {
		return cl;
	}

	public void setCl(List<CatalogoProdotti> cl) {
		this.cl = cl;
	}

	public CatalogoProdottiFacade getcFacade() {
		return cFacade;
	}

	public void setcFacade(CatalogoProdottiFacade cFacade) {
		this.cFacade = cFacade;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
