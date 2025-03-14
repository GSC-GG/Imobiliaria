package model;

//import java.util.ArrayList;
import java.util.List;

public class Locatario {
	private Integer idLocatario;
	private String nome;
	private String telefone;
	private String email;
	private String status;
	private List<Aluguel> listaAluguel;
	
	public Locatario(Integer idLocatario, String nome, String telefone, String email, String status) {
		this.idLocatario = idLocatario;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.status = status;
		this.listaAluguel = null;
	}
	
	public Locatario(Integer idLocatario) {
		this.idLocatario = idLocatario;
		this.nome = null;
		this.telefone = null;
		this.email = null;
		this.status = null;
		this.listaAluguel = null;
	}
	
	public Integer getIdLocatario() {
		return idLocatario;
	}
	public void setIdLocatario(Integer idLocatario) {
		this.idLocatario = idLocatario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
