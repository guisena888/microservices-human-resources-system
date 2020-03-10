package com.gsenas.vaga.form;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class VagaForm {
	
	@NotNull @NotEmpty
	private String titulo;
	
	@NotNull @NotEmpty
	private String descricao;
	
	@NotNull @NotEmpty
	private String nivel;
	
	private BigDecimal salario;
	
	private Long idCandidatoPreSelecionado;

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getNivel() {
		return nivel;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public Long getIdCandidatoPreSelecionado() {
		return idCandidatoPreSelecionado;
	}	
	
}
