


/*
 * A SER APAGADA
 */

package model;

//import java.util.ArrayList;
import java.util.List;

public class Agenda {
	private Integer idAgenda;
	private List<Visita> listaVisita;
	private List<Vistoria> listaVistoria;
	
	public Agenda(Integer idAgenda) {
		this.idAgenda = idAgenda;
		this.listaVisita = null;
		this.listaVistoria = null;
	}

	public Integer getIdAgenda() {
		return idAgenda;
	}

	public void setIdAgenda(Integer idAgenda) {
		this.idAgenda = idAgenda;
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
		this.listaVistoria = listaVistoria;
	}
	
}
	
	