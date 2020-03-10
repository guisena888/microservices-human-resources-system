package com.gsenas.processo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Processo {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long vaga;
	
	private Long candidato;
	
	private Status status;
	
	private Resultado resultado;	
	
	public Processo() {
	}

	public Processo(Long vaga, Long candidato, String status, String resultado) {
		this.vaga = vaga;
		this.candidato = candidato;
		this.status = Status.valueOf(status);
		this.resultado = Resultado.valueOf(resultado);
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}
	
	

}
