package it.uniroma3.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

public class ProductFacade {
	
    private EntityManager entityManager;
    private EntityManagerFactory emf;

	public ProductFacade()  {
		emf = Persistence.createEntityManagerFactory("product-unit");
		entityManager = emf.createEntityManager();
	}

	public Product createProduct(String name, String code, Float price, String description) {
		Product product = new Product(name, price, description, code);
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(product);
		tx.commit();
		entityManager.close();
		emf.close();
		return product;
	}
	
	public Product getProduct(Long id) {
	    Product product = entityManager.find(Product.class, id);
		entityManager.close();
		emf.close();
		return product;
	}
	
	public List<Product> getAllProducts() {
        CriteriaQuery<Product> cq = entityManager.getCriteriaBuilder().createQuery(Product.class);
        cq.select(cq.from(Product.class));
        List<Product> products = entityManager.createQuery(cq).getResultList();
		entityManager.close();
		emf.close();
		return products;
	}

	public void updateProduct(Product product) {
        entityManager.merge(product);
		entityManager.close();
		emf.close();
	}
	
    private void deleteProduct(Product product) {
        entityManager.remove(product);
    }

	public void deleteProduct(Long id) {
        Product product = entityManager.find(Product.class, id);
        deleteProduct(product);
		entityManager.close();
		emf.close();
	}
}
