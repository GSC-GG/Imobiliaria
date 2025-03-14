package model;

//import java.util.ArrayList;

public class Funcionario {
	private Integer idFuncionario;
	private String nome;
	private String telefone;
	private String email;
	
	public Funcionario(Integer idFuncionario, String nome, String telefone, String email) {
		this.idFuncionario = idFuncionario;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}
	
	public Funcionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
		this.nome = null;
		this.telefone = null;
		this.email = null;
	}
	
	public Integer getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
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


