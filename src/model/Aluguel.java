package model;

import java.time.LocalDate;

public class Aluguel {
	private Integer idAluguel;
	private Integer idLocatario;
	private Double valorAluguel;
	private LocalDate dataVencimento;
	private LocalDate dataPagamento;
	private String status;
	
	public Aluguel(Integer idAluguel, Integer idLocatario, Double valor, LocalDate dataVencimento,
			LocalDate dataPagamento, String status) {
		this.idAluguel = idAluguel;
		this.idLocatario = idLocatario;
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
	public Integer getIdLocatario() {
		return idLocatario;
	}
	public void setIdLocatario(Integer idLocatario) {
		this.idLocatario = idLocatario;
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
	