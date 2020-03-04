package com.gsenas.candidato.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Candidato {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private Date dataNascimento;
	
	private String cpf;
	
	private String descricao;
	
	private BigDecimal pretensao;
	
	@OneToMany
	private List<Conhecimento> conhecimentos;

	public Candidato() {
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

	public List<Conhecimento> getConhecimentos() {
		return conhecimentos;
	}

	public void setConhecimentos(List<Conhecimento> conhecimentos) {
		this.conhecimentos = conhecimentos;
	}
	
	
	

}
