package it.uniroma3.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Stateless
public class RigaOrdineFacade {
	@PersistenceContext(unitName="siw-progetto")
	private EntityManager em;
	
	public RigaOrdine createRigaOrdine(Product p, int q){
		RigaOrdine r = new RigaOrdine(p,q);
		em.persist(r);
		return r;
	}
	
	public RigaOrdine getRigaOrdine(Long id){
		RigaOrdine r = em.find(RigaOrdine.class, id);
		return r;
	}
	
	public List<RigaOrdine> getAllRigheOrdine(){
		CriteriaQuery<RigaOrdine> cq = em.getCriteriaBuilder().createQuery(RigaOrdine.class);
		cq.select(cq.from(RigaOrdine.class));
		List<RigaOrdine> l = em.createQuery(cq).getResultList();
		return l;
	}
	
	public void updateRigaOrdine(RigaOrdine r){
		em.merge(r);
	}
	
	public void deleteRigaOrdine(RigaOrdine r){
		em.remove(r);
	}
	
	public void deleteRigaOrdine(Long id){
		RigaOrdine r = getRigaOrdine(id);
		deleteRigaOrdine(r);
	}
	
}
