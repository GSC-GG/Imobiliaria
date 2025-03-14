package model;

import java.time.LocalDate;

public class Vistoria {
	private Integer idVistoria;
	private LocalDate dataVistoria;
	private String resultado;
	
	public Vistoria() {
		
	}
	
	public Vistoria(Integer idVistoria, LocalDate dataVistoria,
			String resultado) {
		this.idVistoria = idVistoria;
		this.dataVistoria = dataVistoria;
		this.resultado = resultado;
	}
	
	public Vistoria(Integer idVistoria) {
		this.idVistoria = idVistoria;
		this.dataVistoria = null;
		this.resultado = null;
	}
	
	public Integer getIdVistoria() {
		return idVistoria;
	}
	public void setIdVistoria(Integer idVistoria) {
		this.idVistoria = idVistoria;
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