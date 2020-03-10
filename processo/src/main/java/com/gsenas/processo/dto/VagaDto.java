package com.gsenas.processo.dto;

import java.math.BigDecimal;
import com.gsenas.processo.model.Nivel;

public class VagaDto {
	
	private String titulo;
	
	private String descricao;
	
	private Nivel nivel;
		
	private BigDecimal salario;
	
	private CandidatoDto candidatoPreSelecionado;

	public VagaDto(String titulo, String descricao, Nivel nivel, BigDecimal salario,
			CandidatoDto candidatoPreSelecionado) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.nivel = nivel;
		this.salario = salario;
		this.candidatoPreSelecionado = candidatoPreSelecionado;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public CandidatoDto getCandidatoPreSelecionado() {
		return candidatoPreSelecionado;
	}

	public void setCandidatoPreSelecionado(CandidatoDto candidatoPreSelecionado) {
		this.candidatoPreSelecionado = candidatoPreSelecionado;
	}	

}
