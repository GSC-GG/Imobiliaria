package model;

//import java.util.ArrayList;
import java.util.List;

public class Imobiliaria {
	private Integer idImobiliaria;
	private String cnpj;
	private List<Corretor> listaCorretor;
	private List<Funcionario> listaFuncionario;
	private List<Imovel> listaImovel;
	
	public Imobiliaria(Integer idImobiliaria, String cnpj) {
		this.idImobiliaria = idImobiliaria;
		this.cnpj = cnpj;
		this.listaCorretor = null;
		this.listaImovel = null;
	}
	
	public Imobiliaria(Integer idImobiliaria) {
		this.idImobiliaria = idImobiliaria;
		this.cnpj = null;
		this.listaCorretor = null;
		this.listaImovel = null;
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

	public List<Funcionario> getListaFuncionario() {
		return listaFuncionario;
	}
	
	public void setListaFuncionario(List<Funcionario> listaFuncionario) {
		this.listaFuncionario= listaFuncionario;
	}

	public List<Imovel> getListaImovel() {
		return listaImovel;
	}

	public void setListaImovel(List<Imovel> listaImovel) {
		this.listaImovel = listaImovel;
	}	
	
}