package model;

import java.time.LocalDate;

public class Contrato {
	private Integer idContrato;
	private ImovelAlugado imovel;
	private Double valorAluguel;
	private LocalDate dataAssinatura;
	private String status;
	
	public Contrato(Integer idContrato, Double valorAluguel, ImovelAlugado imovel, LocalDate dataAssinatura,
			String status) {
		this.idContrato = idContrato;
		this.imovel = imovel;
		this.valorAluguel = valorAluguel;
		this.dataAssinatura = dataAssinatura;
		this.status = status;
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
	public Imovel getImovel() {
		return imovel;
	}
	public void setImovel(ImovelAlugado imovel) {
		this.imovel = imovel;
	}
	public LocalDate getDataAssinatura() {
		return dataAssinatura;
	}
	public void setDataAssinatura(LocalDate dataAssinatura) {
		this.dataAssinatura = dataAssinatura;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
