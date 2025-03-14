package model;

import java.time.LocalDate;

public class Vistoria {
	private Integer idVistoria;
	private Integer idAgenda;
	private Integer idCorretor;
	private LocalDate dataVistoria;
	private String resultado;
	
	public Vistoria(Integer idVistoria, Integer idAgenda, Integer idCorretor, LocalDate dataVistoria,
			String resultado) {
		this.idVistoria = idVistoria;
		this.idAgenda = idAgenda;
		this.idCorretor = idCorretor;
		this.dataVistoria = dataVistoria;
		this.resultado = resultado;
	}
	
	public Vistoria(Integer idVistoria) {
		this.idVistoria = idVistoria;
		this.idAgenda = null;
		this.idCorretor = null;
		this.dataVistoria = null;
		this.resultado = null;
	}
	
	public Integer getIdVistoria() {
		return idVistoria;
	}
	public void setIdVistoria(Integer idVistoria) {
		this.idVistoria = idVistoria;
	}
	public Integer getIdAgenda() {
		return idAgenda;
	}
	public void setIdAgenda(Integer idAgenda) {
		this.idAgenda = idAgenda;
	}
	public Integer getIdCorretor() {
		return idCorretor;
	}
	public void setIdCorretor(Integer idCorretor) {
		this.idCorretor = idCorretor;
	}
	public LocalDate getDataVistoria() {
		return dataVistoria;
	}
	public void setDataVistoria(LocalDate dataVistoria) {
		this.dataVistoria = dataVistoria;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
}