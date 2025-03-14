package model;

public class Imovel {
	private Integer idImovel;
	private Proprietario proprietario;
	private String status;
	private String endereco;
	
	public Imovel(Integer idImovel, String status, String endereco, Proprietario proprietario) {
		this.idImovel = idImovel;
		this.status = status;
		this.endereco = endereco;
		this.proprietario = proprietario;
	}
	
	public Imovel(Imovel imovel) {
		this.idImovel = imovel.idImovel;
		this.status = imovel.status;
		this.endereco = imovel.endereco;
	}
	
	public Imovel(Integer idImovel) {
		this.idImovel = idImovel;
		this.status = null;
		this.endereco = null;
	}

	public Integer getIdImovel() {
		return idImovel;
	}

	public void setIdImovel(Integer idImovel) {
		this.idImovel = idImovel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}
}


