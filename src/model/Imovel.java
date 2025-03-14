package model;

public class Imovel {
	private Integer idImovel;
	private Integer idImobiliaria;
	private Integer idProprietario;
	private String status;
	private String endereco;
	private Integer idAgenda;
	
	public Imovel(Integer idImovel, String status, String endereco, Integer idAgenda, Integer idImobiliaria, Integer idProprietario) {
		this.idImovel = idImovel;
		this.status = status;
		this.endereco = endereco;
		this.idAgenda = idAgenda;
		this.idImobiliaria = idImobiliaria;
		this.idProprietario = idProprietario;
	}
	
	public Imovel(Imovel imovel) {
		this.idImovel = imovel.idImovel;
		this.status = imovel.status;
		this.endereco = imovel.endereco;
		this.idAgenda = imovel.idAgenda;
		this.idImobiliaria = imovel.idImobiliaria;
	}
	
	public Imovel(Integer idImovel) {
		this.idImovel = idImovel;
		this.status = null;
		this.endereco = null;
		this.idAgenda = null;
		this.idImobiliaria = null;
	}

	public Integer getIdImovel() {
		return idImovel;
	}

	public void setIdImovel(Integer idImovel) {
		this.idImovel = idImovel;
	}

	public Integer getIdImobiliaria() {
		return idImobiliaria;
	}

	public void setIdImobiliaria(Integer idImobiliaria) {
		this.idImobiliaria = idImobiliaria;
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

	public Integer getIdAgenda() {
		return idAgenda;
	}

	public void setIdAgenda(Integer idAgenda) {
		this.idAgenda = idAgenda;
	}

	public Integer getIdProprietario() {
		return idProprietario;
	}

	public void setIdProprietario(Integer idProprietario) {
		this.idProprietario = idProprietario;
	}
}


