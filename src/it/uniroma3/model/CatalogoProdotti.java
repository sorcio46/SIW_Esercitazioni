package it.uniroma3.model;

import java.util.ArrayList;
import java.util.List;

public class CatalogoProdotti {
	private List<Product> prodotti = new ArrayList<Product>();
	
	public CatalogoProdotti(){
		//classe Singleton
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
