package it.uniroma3.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;

@Stateless(name="OrdineFacade")
public class OrdineFacade {

	@PersistenceContext(unitName = "siw-progetto")
	private EntityManager em;

	public Ordine createOrder(Date creationDate, Utente customer) {
		Ordine order = new Ordine (creationDate, customer);
		customer.addOrdine(order);
		em.persist(order);
		return order;
	}	

	public Ordine getOrdine(Long id) {
		return this.em.find (Ordine.class, id);
	}

	public List<Ordine> getOrdiniChiusi() {
		List<Ordine> ol = getAllOrdini();
		List<Ordine> out = new ArrayList<Ordine>();
		for(Ordine i : ol){
			if(i.getDataChiusuraOrdine()!=null)
				if(i.getDataEvasioneOrdine()==null)
					out.add(i);
		}
		return out;
	}
	
	public List<Ordine> getOrdiniUtente(Utente u){
		TypedQuery<Ordine> q = this.em.createQuery("SELECT o FROM Order o WHERE o.utente = :utente", Ordine.class);
		q.setParameter("utente", u);
		return q.getResultList();
	}
	
	public void updateOrdine (Ordine o){
		this.em.merge(o);
	}
	
	public List<Ordine> getAllOrdini(){
		CriteriaQuery<Ordine> cq = em.getCriteriaBuilder().createQuery(Ordine.class);
        cq.select(cq.from(Ordine.class));
        List<Ordine> ordini= em.createQuery(cq).getResultList();
		return ordini ;
	}
	
	//
	// Metodo per cancellare un ordine dal database
	//
	private void deleteOrdine(Ordine ordine){
		em.remove(ordine);
	}
	
	//
	// Metodo per la ricerca di un ordine tramite codice e richiamo della cancellazione
	// tramite il parametro codice per un eventuale eliminazione dal database
	//
	public void deleteOrdine(Long id){
		Ordine ordine = em.find(Ordine.class, id);
		deleteOrdine(ordine);
	}
}