package it.uniroma3.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CatalogoProdottiFacade {
	
	@PersistenceContext(unitName= "siw-progetto")
	private EntityManager em;
	
	public CatalogoProdotti createCatalogoProdotti(){
		CatalogoProdotti c = new CatalogoProdotti();
		em.persist(c);
		return c;
	}
	
	public CatalogoProdotti getCatalogoProdotti(Long id){
		CatalogoProdotti c = em.find(CatalogoProdotti.class, id);
		return c;
	}
	
	//Non faccio il metodo per il get della lista dei cataloghi da Database in quanto ne esiste uno
	
	public void updateCatalogoProdotti(CatalogoProdotti c){
		em.merge(c);
	}
	
	public void deleteCatalogoProdotti(CatalogoProdotti c){
		em.remove(c);
	}
	
	public void deleteCatalogoProdotti(Long id){
		CatalogoProdotti c = em.find(CatalogoProdotti.class, id);
		deleteCatalogoProdotti(c);
	}
	
}
