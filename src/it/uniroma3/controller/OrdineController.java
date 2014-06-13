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
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean
public class OrdineController {

	@ManagedProperty(value = "#{param.id}")
	private Long id;
	@ManagedProperty(value= "#{sessionScope['ordine']}")
	private Ordine ordine;
	@ManagedProperty(value = "#{param.pid}")
	private Long pid;
	private Product prodotto;
	private int quantita;
	@ManagedProperty(value= "#{sessionScope['rigaordine']}")
	private RigaOrdine rigaordine;
	private List<Ordine> ordini;
	private List<RigaOrdine> righeOrdine = new ArrayList<RigaOrdine>();
	private Long codice;
	private Date dataAperturaOrdine;
	private Date dataChiusuraOrdine;
	private Date dataEvasioneOrdine;
	private double totale;

	@EJB
	private OrdineFacade ordineFacade;
	@EJB
	private RigaOrdineFacade rFacade;
	@EJB
	private ProductFacade pFacade;

	public String createOrdine() {
		this.ordine = ordineFacade.createOrdine(righeOrdine, dataAperturaOrdine, dataChiusuraOrdine, dataEvasioneOrdine, totale);
		return "ordine";
	}

	public String aggiungiRigaOrdine(){
		this.prodotto = this.pFacade.getProduct(pid);
		this.rigaordine=new RigaOrdine();
		this.rigaordine.setProdotto(prodotto);
		return "riepilogoRigaOrdine"; 
	}
	
	public String confermaRigaOrdine(){
		this.prodotto=this.rigaordine.getProdotto();
		this.rigaordine=rFacade.createRigaOrdine(this.prodotto, quantita);
		this.righeOrdine.add(this.rigaordine);
		return "creaOrdine";
	}
	
	public String listOrdini() {
		this.ordini = ordineFacade.getAllOrdini();
		return "ordini";
	}

	public String findOrdine() {
		this.ordine = ordineFacade.getOrdine(codice);
		return "ordine";
	}

	public String findOrdine(Long codice) {
		this.ordine = ordineFacade.getOrdine(codice);
		return "ordine";
	}

	public Ordine getOrdine() {
		return ordine;
	}

	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}

	public List<Ordine> getOrdini() {
		return ordini;
	}

	public void setOrdini(List<Ordine> ordini) {
		this.ordini = ordini;
	}

	public List<RigaOrdine> getRigaOrdine() {
		return righeOrdine;
	}

	public void setRigaOrdine(List<RigaOrdine> rigaOrdine) {
		this.righeOrdine = rigaOrdine;
	}

	public Long getCodice() {
		return codice;
	}

	public void setCodice(Long codice) {
		this.codice = codice;
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

	public OrdineFacade getOrdineFacade() {
		return ordineFacade;
	}

	public void setOrdineFacade(OrdineFacade ordineFacade) {
		this.ordineFacade = ordineFacade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Product getProdotto() {
		return prodotto;
	}

	public void setProdotto(Product prodotto) {
		this.prodotto = prodotto;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public RigaOrdine getRigaordine() {
		return rigaordine;
	}

	public void setRigaordine(RigaOrdine rigaordine) {
		this.rigaordine = rigaordine;
	}

	public List<RigaOrdine> getRigheOrdine() {
		return righeOrdine;
	}

	public void setRigheOrdine(List<RigaOrdine> righeOrdine) {
		this.righeOrdine = righeOrdine;
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
	
}