package com.gsenas.vaga.dto;

public class ProcessoDto {
	
	private Long id;
	
	private Long vaga;
	
	private Long candidato;
	
	private String status;
	
	private String resultado;	
	
	public ProcessoDto() {
	}

	public ProcessoDto(Long vaga, Long candidato, String status, String resultado) {
		this.vaga = vaga;
		this.candidato = candidato;
		this.status = status;
		this.resultado = resultado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVaga() {
		return vaga;
	}

	public void setVaga(Long vaga) {
		this.vaga = vaga;
	}

	public Long getCandidato() {
		return candidato;
	}

	public void setCandidato(Long candidato) {
		this.candidato = candidato;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
}
