package model;

//import java.util.ArrayList;

public class Corretor {
	private Integer idCorretor;
	private String nome;
	private String telefone;
	private String email;
	
	public Corretor(Integer idCorretor, String nome, String telefone, String email) {
		this.idCorretor = idCorretor;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}
	
	public Corretor(Integer idCorretor) {
		this.idCorretor = idCorretor;
		this.nome = null;
		this.telefone = null;
		this.email = null;
	}
	
	public Integer getIdCorretor() {
		return idCorretor;
	}
	public void setIdCorretor(Integer idCorretor) {
		this.idCorretor = idCorretor;
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
}