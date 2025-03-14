package model;

//import java.util.ArrayList;
import java.util.List;

public class Imobiliaria {
	private Integer idImobiliaria;
	private String cnpj;
	private List<Corretor> listaCorretor;
	private List<Imovel> listaImovel;
	private List<ImovelLivre> listaImovelLivre;
	
	public Imobiliaria(Integer idImobiliaria, String cnpj) {
		this.idImobiliaria = idImobiliaria;
		this.cnpj = cnpj;
		this.listaCorretor = null;
		this.listaImovel = null;
		this.listaImovelLivre = null;
	}
	
	public Imobiliaria(Integer idImobiliaria) {
		this.idImobiliaria = idImobiliaria;
		this.cnpj = null;
		this.listaCorretor = null;
		this.listaImovel = null;
		this.listaImovelLivre = null;
	}
	
	public Integer getIdImobiliaria() {
		return idImobiliaria;
	}
	
	public void setIdImobiliaria(Integer idImobiliaria) {
		this.idImobiliaria = idImobiliaria;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Corretor> getListaCorretor() {
		return listaCorretor;
	}
	
	public void setListaCorretor(List<Corretor> listaCorretor) {
		this.listaCorretor = listaCorretor;
	}

	public List<Imovel> getListaImovel() {
		return listaImovel;
	}

	public void setListaImovel(List<Imovel> listaImovel) {
		this.listaImovel = listaImovel;
	}

	public List<ImovelLivre> getListaImovelLivre() {
		return listaImovelLivre;
	}

	public void setListaImovelLivre(List<ImovelLivre> listaImovelLivre) {
		this.listaImovelLivre = listaImovelLivre;
	}
	
	
	
}