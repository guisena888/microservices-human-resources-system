package com.gsenas.processo.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.gsenas.processo.dto.ConhecimentoDto;

public class CandidatoDto {
	
	private Long id;
	
	private String nome;
	
	private Date dataNascimento;
	
	private String cpf;
	
	private String descricao;
	
	private BigDecimal pretensao;
	
	private List<ConhecimentoDto> conhecimentos;
	
	public CandidatoDto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPretensao() {
		return pretensao;
	}

	public void setPretensao(BigDecimal pretensao) {
		this.pretensao = pretensao;
	}

	public List<ConhecimentoDto> getConhecimentos() {
		return conhecimentos;
	}

	public void setConhecimentos(List<ConhecimentoDto> conhecimentos) {
		this.conhecimentos = conhecimentos;
	}
	
	
}
