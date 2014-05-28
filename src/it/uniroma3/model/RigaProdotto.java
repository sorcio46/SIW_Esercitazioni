package it.uniroma3.model;

public class RigaProdotto {
	
	private Product prodotto;
	public RigaProdotto(Product p){
		this.prodotto=p;
	}
	
	public void setRigaProdotto(Product p){
		this.prodotto=p;
	}
	
	public Product getRigaProdotto(){
		return this.prodotto;
	}
	
    public boolean equals(Object obj) {
        RigaProdotto rp = (RigaProdotto)obj;
        return this.prodotto.equals(rp.getRigaProdotto());
    }

    public int hashCode() {
         return this.prodotto.getId().hashCode();
    }
}
