package com.gsenas.candidato.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsenas.candidato.model.Candidato;
import com.gsenas.candidato.repository.CandidatoRepository;

@Service
public class CandidatoService {
	
	@Autowired
	private CandidatoRepository candidatoRepository;
	
	public Optional<Candidato> findById(Long id){ 
		Optional<Candidato> optional = candidatoRepository.findById(id);
		return optional;
	}
}
