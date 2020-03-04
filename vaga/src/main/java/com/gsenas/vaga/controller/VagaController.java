package com.gsenas.vaga.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gsenas.vaga.dto.VagaDto;
import com.gsenas.vaga.model.Vaga;
import com.gsenas.vaga.service.VagaService;

@RestController
@RequestMapping("/vaga")
public class VagaController {

	@Autowired
	private VagaService vagaService;
	
	@GetMapping
	public ResponseEntity<List<Vaga>> findAll() {
		List<Vaga> vagas = vagaService.findAll();
		if(vagas.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(vagas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<VagaDto> findById(@PathVariable Long id) {
		VagaDto vaga = vagaService.findById(id);
		if(vaga != null) {
			return ResponseEntity.ok(vaga);
		}
		
		return ResponseEntity.notFound().build();
	}
	
}
