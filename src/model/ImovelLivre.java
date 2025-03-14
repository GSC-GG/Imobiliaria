package model;

import java.util.List;

public class ImovelLivre extends Imovel{
	private List<Visita> listaVisita;
	private List<Vistoria> listaVistoria;

	public ImovelLivre(Integer idImovel, String status, String endereco, Proprietario proprietario) {
		super(idImovel, status, endereco, proprietario);
		this.listaVisita = null;
		this.listaVistoria = null;
	}

	public ImovelLivre(Imovel imovel) {
		super(imovel);
	}

	public ImovelLivre(Integer idImovel) {
		super(idImovel);
	}
	
	public List<Visita> getListaVisita() {
		return listaVisita;
	}
	public void setListaVisita(List<Visita> listaVisita) {
		this.listaVisita = listaVisita;
	}
	
	public List<Vistoria> getListaVistoria() {
		return listaVistoria;
	}
	public void setListaVistoria(List<Vistoria> listaVistoria) {
		this.listaVistoria= listaVistoria;
	}

}