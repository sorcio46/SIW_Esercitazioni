package it.uniroma3.model;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

public class OrdineFacade {

	
		@PersistenceContext(unitName = "siw-progetto")
			private EntityManager em;
		
		//Metodo per la persistenza di un ordine
			public Ordine createOrdine(List<RigaOrdine> rigaOrdine, Date dataAperturaOrdine, Date dataChiusuraOrdine, Date dataEvasioneOrdine, double totale, Utente u){
				Ordine ordine = new Ordine( rigaOrdine, dataAperturaOrdine, dataChiusuraOrdine, dataEvasioneOrdine, totale, u);
				em.persist(ordine);
				return ordine;
			}
			
		//Metodo per richiamare un ordine
			public Ordine getOrdine(long id){
				Ordine ordine = em.find(Ordine.class, id);
				return ordine;
			}
			
		//Metodo per richiamare tutti gli ordini	
			public List<Ordine> getAllOrdini() {
				CriteriaQuery<Ordine> cq = em.getCriteriaBuilder().createQuery(Ordine.class);
				cq.select(cq.from(Ordine.class));
				List<Ordine> ordine = em.createQuery(cq).getResultList();
				return ordine;
			}
			
		//Metodo per fare il merge dell'ordine sul database
			public void updateOrdine(Ordine ordine){
				em.merge(ordine);
			}
			
			public void updateOrdine(Long id){
				Ordine ordine = em.find(Ordine.class, id);
				updateOrdine(ordine);
			}
			
		//Metodo per cancellare un ordine dal database
			private void deleteOrdine(Ordine ordine){
				em.remove(ordine);
			}
			
		// Metodo per la ricerca di un ordine tramite codice e richiamo della cancellazione
		//tramite il parametro codice per un eventuale eliminazione dal database
			public void deleteOrdine(Long id){
				Ordine ordine = em.find(Ordine.class, id);
			deleteOrdine(ordine);
			}
			
}
