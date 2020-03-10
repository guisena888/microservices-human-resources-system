package com.gsenas.candidato.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gsenas.candidato.model.Candidato;
import com.gsenas.candidato.service.CandidatoService;

@RestController
@RequestMapping("/candidato")
public class CandidatoController {

	@Autowired
	private CandidatoService candidatoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Candidato> findById(@PathVariable Long id) {
		Optional<Candidato> optional = candidatoService.findById(id);
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		return ResponseEntity.notFound().build();
		
	}
	
	
	
}
