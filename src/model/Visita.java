package model;

import java.time.LocalDate;

public class Visita {
	private Integer idVisita;
	private Integer idAgenda;
	private Integer idCorretor;
	private LocalDate dataVisita;
	private String status;
	
	public Visita(Integer idVisita, Integer idAgenda, Integer idCorretor, LocalDate dataVisita, String status) {
		this.idVisita = idVisita;
		this.idAgenda = idAgenda;
		this.idCorretor = idCorretor;
		this.dataVisita = dataVisita;
		this.status = status;
	}
	
	public Visita(Integer idVisita) {
		this.idVisita = idVisita;
		this.idAgenda = null;
		this.idCorretor = null;
		this.dataVisita = null;
		this.status = null;
	}
	
	public Integer getIdVisita() {
		return idVisita;
	}
	public void setIdVisita(Integer idVisita) {
		this.idVisita = idVisita;
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
