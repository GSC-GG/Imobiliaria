package model;

public class Funcionario extends Individuo {
	private Integer idFuncionario;
	
	public Funcionario(Integer idFuncionario, String nome, String telefone, String email) {
		super(nome, telefone, email);
		this.idFuncionario = idFuncionario;
	}
	
	public Funcionario(Integer idFuncionario) {
		super();
		this.idFuncionario = idFuncionario;
	}
	
	public Integer getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
}


