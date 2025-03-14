package model;

//import java.util.ArrayList;

public class Proprietario {
	protected Integer idProprietario;
	protected String nome;
	protected String telefone;
	protected String email;
	
	public Proprietario(Integer idProprietario, String nome, String telefone, String email) {
		this.idProprietario = idProprietario;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}
	
	public Proprietario(Integer idProprietario) {
		this.idProprietario = idProprietario;
		this.nome = null;
		this.telefone = null;
		this.email = null;
	}
	
	public Integer getIdProprietario() {
		return idProprietario;
	}
	public void setIdProprietario(Integer idProprietario) {
		this.idProprietario = idProprietario;
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
