package it.uniroma3.model;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

@Stateless
public class UtenteFacade {
		
	 @PersistenceContext(unitName = "siw-progetto")
	    private EntityManager em;
	    
	 //Metodo per la persistenza di un utente
		public Utente createUtente(String nome, String cognome, Date dataDiNascita, Date dataDiRegistrazione, String indirizzo, String mail,
		String password) {
			Utente utente = new Utente(nome,cognome, dataDiNascita, dataDiRegistrazione, indirizzo, mail, password);
			em.persist(utente);
			return utente;
		}
		
	//Metodo per richiamare un utente	
		public Utente getUtente(Long id) {
		    Utente utente = em.find(Utente.class, id);
			return utente;
		}
	
	//Metodo per richiamare tutti gli utenti
		public List<Utente> getAllUtenti() {
	        CriteriaQuery<Utente> cq = em.getCriteriaBuilder().createQuery(Utente.class);
	        cq.select(cq.from(Utente.class));
	        List<Utente> utenti = em.createQuery(cq).getResultList();
			return utenti;
		}
	
	//Metodo per fare il merge dell'utente sul database
		public void updateUtente(Utente utente) {
	        em.merge(utente);
		}
	
	//Metodo per cancellare un utente dal database
	    private void deleteUtente(Utente utente) {
	        em.remove(utente);
	    }
	    
	//Metodo per la ricerca di un utente tramite e id e richiamo della cancellazione tramite
	//il parametro id per un eventuale eliminazione dal database
		public void deleteUtente(Long id) {
	        Utente utente = em.find(Utente.class, id);
	        deleteUtente(utente);
		}

}
