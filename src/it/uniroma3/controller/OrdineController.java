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
import javax.faces.context.FacesContext;

@ManagedBean
public class OrdineController {

	@ManagedProperty(value = "#{param.id}")
	private Long id;
	private int quantita;
	private List<Ordine> ordini;
	private List<RigaOrdine> righeOrdine;
	private Date dataAperturaOrdine;
	private Date dataChiusuraOrdine;
	private Date dataEvasioneOrdine;
	private double totale;
	private Ordine ordine;
	private Utente utente;
	
	@ManagedProperty(value= "#{sessionScope['products']}")
	private List<Product> products;
	
	@ManagedProperty(value= "#{sessionScope['ordineCorrente']}")
	private Ordine ordineCorrente;
	
	@ManagedProperty(value = "#{param.pid}")
	private Long pid;
	
	@ManagedProperty(value = "#{param.uid}")
	private Long uid;
	
	@ManagedProperty(value= "#{sessionScope['rigaordine']}")
	private RigaOrdine rigaordine;

	@ManagedProperty(value= "#{sessionScope['prodotto']}")
	private Product prodotto;
	
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
		//this.ordine = ordineFacade.createOrdine(righeOrdine, dataAperturaOrdine, dataChiusuraOrdine, dataEvasioneOrdine, totale, utente);
		return "ordine";
	}
	
	//
	// METODO 1
	// Il controller riceve dalla Index il messaggio di prepararsi alla creazione
	// di un nuovo ordine
	//
	public String inizializzaOrdine(){
		
		this.products = pFacade.getAllProducts();
		this.utente = uFacade.getUtente(uid);
		
		this.righeOrdine = new ArrayList<RigaOrdine>();
		this.ordineCorrente=ordineFacade.createOrder(new Date(), this.utente);
		
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("ordineCorrente", this.ordineCorrente);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("products", this.products);
		
		return "creaOrdine";
	}
	
	//
	// Metodo 2
	// Il controller riceve dalla JSP creaOrdine il comando
	// di generare un prodotto associato all pid passato da parametro
	//
	public String aggiungiRigaOrdine(){
		this.prodotto = this.pFacade.getProduct(pid);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("prodotto", this.prodotto);
		return "riepilogoRigaOrdine";
	}
	
	//
	// Metodo 3
	// Il controller riceve dalla JSP riepilogoRigaOrdine il comando
	// di creare la rigaOrdine e di persisterla, poi di aggiungerla all'ordine
	//
	public String confermaRigaOrdine(){
		this.rigaordine=rFacade.createRigaOrdine(this.prodotto, quantita, this.ordineCorrente);
		ordineCorrente.aggiungiRigaOrdine(this.rigaordine);
		return "rigaOrdine";
	}
	
	//
	// METODO 4
	// Il controller riceve da una jsp il comando di chiudere l'ordine corrente
	//
	public String chiudiOrdine(){
		
		for(RigaOrdine ro : ordineCorrente.getRigheOrdine()){
			double prezzo = ro.getProdotto().getPrice();
			totale = totale + (prezzo*ro.getQuantita());
		}
		
		ordineCorrente.setTotale(totale);
		ordineCorrente.setDataChiusuraOrdine(new Date());
		
		ordineFacade.updateOrdine(ordineCorrente);
		
		return "ordine";
	}
	
	public String aggiungiAltraRigaOrdine(){
		return "creaOrdine";
	}
	
	//
	// Metodo per l'evasione dell'ordine
	//
	public String evadiOrdine(){
		ordineCorrente = this.ordineFacade.getOrdine(this.id);
		if(this.verificaDisponibilita(ordineCorrente)){
			this.evadiOrdine(ordineCorrente);
			this.aggiornaMagazzino(ordineCorrente);
		}
		this.ordini = (List<Ordine>) this.ordineFacade.getOrdiniChiusi();
		return "evadiOrdine";
	}
	
	//
	// Metodo per la verifica della disponibilita
	// delle righe ordine di un Ordine
	//
	public boolean verificaDisponibilita(Ordine o){
		boolean var = true;
		Product p;
		List<RigaOrdine> rp = o.getRigheOrdine();
		for(RigaOrdine i : rp){
			p = pFacade.getProduct(i.getProdotto().getId());
			if(i.getQuantita()>p.getDisponibilita())
				var=false;
		}
		return var;
	}
	
	//
	// Metodo per l'evasione di un Ordine confermato
	//
	public void evadiOrdine(Ordine o){
		ordineCorrente.setDataEvasioneOrdine(new Date());
		ordineFacade.updateOrdine(o);
	}
	
	public void aggiornaMagazzino(Ordine o){
		for(RigaOrdine r : o.getRigheOrdine()){
			Product p = r.getProdotto();
			p.setDisponibilita(p.getDisponibilita()-r.getQuantita());
			this.pFacade.updateProduct(p);
		}
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
	
	//
	// Metodo per la stampa degli ordini
	//
	public String listaOrdini() {
		this.utente=uFacade.getUtente(uid);
		this.ordini = ordineFacade.getAllOrdini();
		return "ordiniUtente";
	}
	
	public String listaOrdiniAdmin(){
		this.ordini = ordineFacade.getAllOrdini();
		return "ordiniAmministratori";
	}
	
	//
	// Metodo per la stampa degli ordini
	//
	public String preparaEvasioneOrdini(){
		this.ordini = ordineFacade.getAllOrdini();
		return "evadiOrdine";
	}
	
	//
	// Metodo per la stampa degli ordini di un utente
	// DA TESTARE
	//
	public String listaOrdiniUtente() {
		this.utente=uFacade.getUtente(uid);
		this.ordini = ordineFacade.getOrdiniUtente(this.utente);
		return "ordiniUtente";
	}

	//
	// Metodo per trovare un ordine a partire dall'id
	//
	public String findOrdine() {
		this.ordine = ordineFacade.getOrdine(id);
		this.righeOrdine = this.ordine.getRigheOrdine();
		this.ordineCorrente = ordine;
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