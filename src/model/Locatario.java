package model;

//import java.util.ArrayList;
import java.util.List;

public class Locatario extends Individuo {
	private Integer idLocatario;
	private String status;
	private List<Aluguel> listaAluguel;
	
	public Locatario(Integer idLocatario, String nome, String telefone, String email, String status) {
		super(nome, telefone, email);
		this.idLocatario = idLocatario;
		this.status = status;
		this.listaAluguel = null;
	}
	
	public Locatario(Integer idLocatario) {
		super();
		this.idLocatario = idLocatario;
		this.status = null;
		this.listaAluguel = null;
	}
	
	public Integer getIdLocatario() {
		return idLocatario;
	}
	public void setIdLocatario(Integer idLocatario) {
		this.idLocatario = idLocatario;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public List<Aluguel> getListaAluguel() {
		return listaAluguel;
	}

	public void setListaAluguel(List<Aluguel> listaAluguel) {
		this.listaAluguel = listaAluguel;
	}
}
