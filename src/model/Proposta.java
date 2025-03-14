package model;

public class Proposta {
	private Integer idProposta;
	private Contrato contrato;
	private Double valorAluguel;
	
	public Proposta(Integer idProposta, Contrato contrato, Double valorAluguel) {
		this.idProposta = idProposta;
		this.contrato = contrato;
		this.valorAluguel = valorAluguel;
	}
	
	public Integer getIdProposta() {
		return idProposta;
	}
	public void setIdProposta(Integer idProposta) {
		this.idProposta = idProposta;
	}
	public Contrato getContrato() {
		return contrato;
	}
	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}
	public Double getValorAluguel() {
		return valorAluguel;
	}
	public void setValorAluguel(Double valorAluguel) {
		this.valorAluguel = valorAluguel;
	}
	
	
}
	
	