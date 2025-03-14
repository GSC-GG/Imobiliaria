package model;

import java.time.LocalDate;

public class Visita {
	private Integer idVisita;
	private LocalDate dataVisita;
	private String status;
	
	public Visita(Integer idVisita, LocalDate dataVisita, String status) {
		this.idVisita = idVisita;
		this.dataVisita = dataVisita;
		this.status = status;
	}
	
	public Visita(Integer idVisita) {
		this.idVisita = idVisita;
		this.dataVisita = null;
		this.status = null;
	}
	
	public Integer getIdVisita() {
		return idVisita;
	}
	public void setIdVisita(Integer idVisita) {
		this.idVisita = idVisita;
	}
	
	public LocalDate getDataVisita() {
		return dataVisita;
	}
	public void setDataVisita(LocalDate dataVisita) {
		this.dataVisita = dataVisita;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
