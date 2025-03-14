package model;

public class Proposta {
	private Integer idProposta;
	private Integer idContrato;
	private Double valorAluguel;
	
	public Proposta(Integer idProposta, Integer idContrato, Double valorAluguel) {
		this.idProposta = idProposta;
		this.idContrato = idContrato;
		this.valorAluguel = valorAluguel;
	}
	
	public Integer getIdProposta() {
		return idProposta;
	}
	public void setIdProposta(Integer idProposta) {
		this.idProposta = idProposta;
	}
	public Integer getIdContrato() {
		return idContrato;
	}
	public void setIdContrato(Integer idContrato) {
		this.idContrato = idContrato;
	}
	public Double getValorAluguel() {
		return valorAluguel;
	}
	public void setValorAluguel(Double valorAluguel) {
		this.valorAluguel = valorAluguel;
	}
	
	
}
	
	