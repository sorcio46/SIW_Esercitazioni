package it.uniroma3.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Stateless
public class AmministratoreFacade {
	
	@PersistenceContext(unitName= "siw-progetto")
	private EntityManager em;
	
	//Metodo per la persistenza nel database
	public Amministratore createAmministratore(String nome, String cognome, String mail,String password){
		Amministratore a = new Amministratore(nome,cognome,mail,password);
		em.persist(a);
		return a;
	}
	
	//Metodo per il get dal database
	public Amministratore getAmministratore(Long id){
		Amministratore a=em.find(Amministratore.class, id);
		return a;
	}
	
	//Metodo per il ritorno di una lista di Amministratori
	public List<Amministratore> getAllAmministratori(){
		CriteriaQuery<Amministratore> cq = em.getCriteriaBuilder().createQuery(Amministratore.class);
		cq.select(cq.from(Amministratore.class));
		List<Amministratore> a = em.createQuery(cq).getResultList();
		return a;
	}
	
	//Metodo per il merge sul database
	public void updateAmministratore(Amministratore a){
		em.merge(a);
	}
	
	//Metodo per la rimozione dal database
	public void deleteAmministratore(Amministratore a){
		em.remove(a);
	}
	
	//Metodo per la ricerca di un Amministratore dal database
	//a partire da un Id e la sua eventuale cancellazione
	public void deleteAmministratore(Long id){
		Amministratore a = em.find(Amministratore.class, id);
		deleteAmministratore(a);
	}
}
