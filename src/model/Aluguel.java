package model;

import java.time.LocalDate;

public class Aluguel {
	private Integer idAluguel;
	private Double valorAluguel;
	private LocalDate dataVencimento;
	private LocalDate dataPagamento;
	private String status;
	
	public Aluguel(Integer idAluguel, Double valor, LocalDate dataVencimento,
			LocalDate dataPagamento, String status) {
		this.idAluguel = idAluguel;
		this.valorAluguel = valor;
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
		this.status = status;
	}
	
	public Integer getIdAluguel() {
		return idAluguel;
	}
	public void setIdAluguel(Integer idAluguel) {
		this.idAluguel = idAluguel;
	}
	public Double getValorAluguel() {
		return valorAluguel;
	}
	public void setValorAluguel(Double valorAluguel) {
		this.valorAluguel = valorAluguel;
	}
	public LocalDate getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public LocalDate getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
	