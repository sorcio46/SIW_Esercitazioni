package it.uniroma3.model;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
public class FornitoreFacade {
		
	 @PersistenceContext(unitName = "siw-progetto")
	    private EntityManager em;
	    
	 //Metodo per la persistenza di un fornitore
		public Fornitore createFornitore(String nome, String partitaIVA, String indirizzo) {
			Fornitore fornitore = new Fornitore(nome, partitaIVA, indirizzo);
			em.persist(fornitore);
			return fornitore;
		}
		
	//Metodo per richiamare un fornitore
		public Fornitore getFornitore(Long id) {
		    Fornitore fornitore = em.find(Fornitore.class, id);
			return fornitore;
		}
	
	//Metodo per richiamare tutti gli fornitore
		public List<Fornitore> getAllFornitori() {
	        CriteriaQuery<Fornitore> cq = em.getCriteriaBuilder().createQuery(Fornitore.class);
	        cq.select(cq.from(Fornitore.class));
	        List<Fornitore> fornitore= em.createQuery(cq).getResultList();
			return fornitore;
		}
	
	//Metodo per fare il merge del fornitore sul database
		public void updateFornitore(Fornitore fornitore) {
	        em.merge(fornitore);
		}
	
	//Metodo per cancellare un fornitore dal database
	    private void deleteFornitore(Fornitore fornitore) {
	        em.remove(fornitore);
	    }
	    
	//Metodo per la ricerca di un fornitore tramite e id e richiamo della cancellazione tramite
	//il parametro id per un eventuale eliminazione dal database
		public void deleteFornitore(Long id) {
			Fornitore fornitore = em.find(Fornitore.class, id);
	        deleteFornitore(fornitore);
		}
		
}