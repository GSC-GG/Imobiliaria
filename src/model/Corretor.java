package model;

//import java.util.List;

//import java.util.ArrayList;

public class Corretor extends Individuo {
	private Integer idCorretor;
	
	public Corretor(Integer idCorretor, String nome, String telefone, String email) {
		super(nome, telefone, email);
		this.idCorretor = idCorretor;
	}
	
	public Corretor(Integer idCorretor) {
		super();
		this.idCorretor = idCorretor;
	}
	
	public Integer getIdCorretor() {
		return idCorretor;
	}
	public void setIdCorretor(Integer idCorretor) {
		this.idCorretor = idCorretor;
	}
}