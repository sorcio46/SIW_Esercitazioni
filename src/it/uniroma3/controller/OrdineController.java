package it.uniroma3.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import it.uniroma3.model.Ordine;
import it.uniroma3.model.OrdineFacade;
import it.uniroma3.model.Product;
import it.uniroma3.model.ProductFacade;
import it.uniroma3.model.RigaOrdine;
import it.uniroma3.model.RigaOrdineFacade;
import it.uniroma3.model.Utente;
import it.uniroma3.model.UtenteFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean
public class OrdineController {

	@ManagedProperty(value = "#{param.id}")
	private Long id;
	
	@ManagedProperty(value= "#{sessionScope['ordineCorrente']}")
	private Ordine ordineCorrente;
	private Ordine ordine;
	
	@ManagedProperty(value = "#{param.pid}")
	private Long pid;
	
	@ManagedProperty(value = "#{param.uid}")
	private Long uid;
	
	@ManagedProperty(value= "#{sessionScope['rigaordine']}")
	private RigaOrdine rigaordine;
	
	private int quantita;	
	private Product prodotto;
	private List<Ordine> ordini;
	private List<RigaOrdine> righeOrdine = new ArrayList<RigaOrdine>();
	
	private Date dataAperturaOrdine;
	private Date dataChiusuraOrdine;
	private Date dataEvasioneOrdine;
	private double totale;
	private Utente utente;
	
	private List<Product> products;
	
	@EJB
	private OrdineFacade ordineFacade;
	@EJB
	private RigaOrdineFacade rFacade;
	@EJB
	private ProductFacade pFacade;
	@EJB
	private UtenteFacade uFacade;

	public String createOrdine() {
		utente = uFacade.getUtente(uid);
		this.ordine = ordineFacade.createOrdine(righeOrdine, dataAperturaOrdine, dataChiusuraOrdine, dataEvasioneOrdine, totale, utente);
		return "ordine";
	}
	
	public String inizializzaOrdine(){
		
		this.products = pFacade.getAllProducts();
		utente = uFacade.getUtente(uid);
		
		dataAperturaOrdine=new Date();
		dataChiusuraOrdine=new Date();
		dataEvasioneOrdine=new Date();
		
		this.ordineCorrente = ordineFacade.createOrdine(righeOrdine, dataAperturaOrdine, dataChiusuraOrdine, dataEvasioneOrdine, totale, utente);
		return "creaOrdine";
	}

	public String aggiungiRigaOrdine(){
		this.ordine = null;
		this.prodotto = this.pFacade.getProduct(pid);
		return "riepilogoRigaOrdine"; 
	}
	
	public String confermaRigaOrdine(){
		this.prodotto = this.pFacade.getProduct(pid);
		this.rigaordine=rFacade.createRigaOrdine(this.prodotto, quantita);
		//QUI FA NULL POINTER EXCEPTION
		this.ordineCorrente.getRigheOrdine().add(this.rigaordine);
		return "rigaOrdine";
	}
	
	public String chiudiOrdine(){
		
		for(RigaOrdine ro : this.ordineCorrente.getRigheOrdine()){
			double prezzo = ro.getProdotto().getPrice();
			totale = totale + (prezzo*ro.getQuantita());
		}
		
		this.ordineCorrente.setTotale(totale);
		
		for(RigaOrdine ro : righeOrdine){
			ro.setOrdine(this.ordineCorrente);
			rFacade.updateRigaOrdine(ro.getId());
		}
		
		return "ordine";
	}
	
	public String getUtenteDaOrdine(){
		try{
			this.ordine=this.ordineFacade.getOrdine(this.id);
		    this.utente = this.ordine.getUtente();
		} catch(Exception e){return "index";}
		return "utente";
	}
	
	public String listaOrdiniChiusi(){
		this.ordini = this.ordineFacade.getOrdiniChiusi();
		return "tuttiGliOrdini";
	}
	
	public String listOrdini() {
		this.ordini = ordineFacade.getAllOrdini();
		return "ordini";
	}

	public String findOrdine() {
		this.ordine = ordineFacade.getOrdine(id);
		return "ordine";
	}

	public String findOrdine(Long codice) {
		this.ordine = ordineFacade.getOrdine(codice);
		return "ordine";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ordine getOrdineCorrente() {
		return ordineCorrente;
	}

	public void setOrdineCorrente(Ordine ordineCorrente) {
		this.ordineCorrente = ordineCorrente;
	}

	public Ordine getOrdine() {
		return ordine;
	}

	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public RigaOrdine getRigaordine() {
		return rigaordine;
	}

	public void setRigaordine(RigaOrdine rigaordine) {
		this.rigaordine = rigaordine;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public Product getProdotto() {
		return prodotto;
	}

	public void setProdotto(Product prodotto) {
		this.prodotto = prodotto;
	}

	public List<Ordine> getOrdini() {
		return ordini;
	}

	public void setOrdini(List<Ordine> ordini) {
		this.ordini = ordini;
	}

	public List<RigaOrdine> getRigheOrdine() {
		return righeOrdine;
	}

	public void setRigheOrdine(List<RigaOrdine> righeOrdine) {
		this.righeOrdine = righeOrdine;
	}

	public Date getDataAperturaOrdine() {
		return dataAperturaOrdine;
	}

	public void setDataAperturaOrdine(Date dataAperturaOrdine) {
		this.dataAperturaOrdine = dataAperturaOrdine;
	}

	public Date getDataChiusuraOrdine() {
		return dataChiusuraOrdine;
	}

	public void setDataChiusuraOrdine(Date dataChiusuraOrdine) {
		this.dataChiusuraOrdine = dataChiusuraOrdine;
	}

	public Date getDataEvasioneOrdine() {
		return dataEvasioneOrdine;
	}

	public void setDataEvasioneOrdine(Date dataEvasioneOrdine) {
		this.dataEvasioneOrdine = dataEvasioneOrdine;
	}

	public double getTotale() {
		return totale;
	}

	public void setTotale(double totale) {
		this.totale = totale;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public OrdineFacade getOrdineFacade() {
		return ordineFacade;
	}

	public void setOrdineFacade(OrdineFacade ordineFacade) {
		this.ordineFacade = ordineFacade;
	}

	public RigaOrdineFacade getrFacade() {
		return rFacade;
	}

	public void setrFacade(RigaOrdineFacade rFacade) {
		this.rFacade = rFacade;
	}

	public ProductFacade getpFacade() {
		return pFacade;
	}

	public void setpFacade(ProductFacade pFacade) {
		this.pFacade = pFacade;
	}

	public UtenteFacade getuFacade() {
		return uFacade;
	}

	public void setuFacade(UtenteFacade uFacade) {
		this.uFacade = uFacade;
	}
	
}