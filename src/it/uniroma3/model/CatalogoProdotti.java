package it.uniroma3.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Column;

@Entity
@NamedQuery(name="trovaTuttiICataloghiProdotti", query="SELECT c from CatalogoProdotti c")
public class CatalogoProdotti {
	
	@Column
	private List<Product> prodotti = new ArrayList<Product>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	public CatalogoProdotti(){
		//classe Singleton
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
}
