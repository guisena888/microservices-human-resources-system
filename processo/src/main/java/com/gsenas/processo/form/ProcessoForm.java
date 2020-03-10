package com.gsenas.processo.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProcessoForm {

	@NotNull
	private Long vaga;
	
	@NotNull
	private Long candidato;
	
	@NotNull @NotEmpty
	private String status;
	
	@NotNull @NotEmpty
	private String resultado;

	public Long getVaga() {
		return vaga;
	}

	public Long getCandidato() {
		return candidato;
	}

	public String getStatus() {
		return status;
	}

	public String getResultado() {
		return resultado;
	}
	
	
	
	
}
