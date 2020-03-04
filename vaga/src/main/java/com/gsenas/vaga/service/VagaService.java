package com.gsenas.vaga.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsenas.vaga.client.CandidatoClient;
import com.gsenas.vaga.dto.CandidatoDto;
import com.gsenas.vaga.dto.VagaDto;
import com.gsenas.vaga.model.Vaga;
import com.gsenas.vaga.repository.VagaRepository;

@Service
public class VagaService {

	@Autowired
	private VagaRepository vagaRepository;
	
	@Autowired
	private CandidatoClient candidatoClient;
	
	public List<Vaga> findAll() {
		return vagaRepository.findAll();
	}

	public VagaDto findById(Long id) {
		Optional<Vaga> optional = vagaRepository.findById(id);
		if(optional.isPresent()) {
			Vaga vaga = optional.get();
			if(vaga.getIdCandidatoPreSelecionado() != null) {
				CandidatoDto candidato = candidatoClient.findById(id);
				VagaDto vagaDto = new VagaDto(vaga, candidato);
				return vagaDto;
			}
		}
		
		return null;
	}

}
