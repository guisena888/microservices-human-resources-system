package com.gsenas.vaga.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gsenas.vaga.client.CandidatoClient;
import com.gsenas.vaga.client.ProcessoClient;
import com.gsenas.vaga.dto.CandidatoDto;
import com.gsenas.vaga.dto.ProcessoDto;
import com.gsenas.vaga.dto.VagaDto;
import com.gsenas.vaga.form.ProcessoForm;
import com.gsenas.vaga.form.VagaForm;
import com.gsenas.vaga.model.Nivel;
import com.gsenas.vaga.model.Vaga;
import com.gsenas.vaga.repository.VagaRepository;

@Service
public class VagaService {

	@Autowired
	private VagaRepository vagaRepository;
	
	@Autowired
	private CandidatoClient candidatoClient;
	
	@Autowired
	private ProcessoClient processoClient;
	
	public Page<Vaga> findAll(Pageable pagination) {
		return vagaRepository.findAll(pagination);
	}

	public VagaDto findById(Long id) {
		Optional<Vaga> optional = vagaRepository.findById(id);
		CandidatoDto candidato = new CandidatoDto();
		if(optional.isPresent()) {
			Vaga vaga = optional.get();
			if(vaga.getIdCandidatoPreSelecionado() != null) {
				candidato = candidatoClient.findById(vaga.getIdCandidatoPreSelecionado());
			}
			VagaDto vagaDto = new VagaDto(vaga, candidato);
			return vagaDto;
		}
		
		return null;
	}

	public Page<Vaga> findByTitulo(String vagaTitulo, Pageable pagination) {
		return vagaRepository.findByTitulo(vagaTitulo, pagination);
	}

	public Vaga create(@Valid VagaForm form) {
		Vaga vaga = new Vaga(
				form.getTitulo(),
				form.getDescricao(),
				Nivel.valueOf(form.getNivel()),
				form.getSalario(),
				form.getIdCandidatoPreSelecionado());
		vagaRepository.save(vaga);
		return vaga;
	}

	public Vaga update(Long id, @Valid VagaForm form) {
		Optional<Vaga> optional = vagaRepository.findById(id);
		if(optional.isPresent()) {
			Vaga vaga = optional.get();
			vaga.setTitulo(form.getTitulo());
			vaga.setDescricao(form.getDescricao());
			vaga.setNivel(Nivel.valueOf(form.getNivel()));
			vaga.setSalario(form.getSalario());
			vaga.setIdCandidatoPreSelecionado(form.getIdCandidatoPreSelecionado());
			return vaga;
		}
		return null;
	}

	public boolean delete(Long id) {
		Optional<Vaga> optional = vagaRepository.findById(id);
		if(optional.isPresent()) {
			vagaRepository.delete(optional.get());
			return true;
		}
		return false;
	}

	public ProcessoDto candidatar(@Valid ProcessoForm form) {
		return processoClient.create(form);
	}

}
