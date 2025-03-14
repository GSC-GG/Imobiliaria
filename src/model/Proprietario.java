package model;

public class Proprietario extends Individuo {
	private Integer idProprietario;
	
	public Proprietario(Integer idProprietario, String nome, String telefone, String email) {
		super(nome, telefone, email);
		this.idProprietario = idProprietario;
	}
	
	public Proprietario(Integer idProprietario) {
		super();
		this.idProprietario = idProprietario;
	}
	
	public Proprietario() {
		
	}
	
	public Integer getIdProprietario() {
		return idProprietario;
	}
	public void setIdProprietario(Integer idProprietario) {
		this.idProprietario = idProprietario;
	}
}


