package com.gsenas.vaga.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gsenas.vaga.dto.ProcessoDto;
import com.gsenas.vaga.dto.VagaDto;
import com.gsenas.vaga.form.ProcessoForm;
import com.gsenas.vaga.form.VagaForm;
import com.gsenas.vaga.model.Vaga;
import com.gsenas.vaga.service.VagaService;

@RestController
@RequestMapping("/vaga")
public class VagaController {

	@Autowired
	private VagaService vagaService;
	
	@GetMapping
	public Page<Vaga> findAll(@RequestParam(required=false) String vagaTitulo,
			@PageableDefault(sort = "id", size = 5, direction=Direction.ASC) Pageable pagination) {
		
		if(vagaTitulo == null) {
			Page<Vaga> vagas = vagaService.findAll(pagination);
			return vagas;
		} else {
			Page<Vaga> vagas = vagaService.findByTitulo(vagaTitulo, pagination);
			return vagas;
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<VagaDto> findById(@PathVariable Long id) {
		VagaDto vaga = vagaService.findById(id);
		if(vaga != null) {
			return ResponseEntity.ok(vaga);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<Vaga> create(@RequestBody @Valid VagaForm form, UriComponentsBuilder uriBuilder){
		Vaga vaga = vagaService.create(form);
		
		URI uri = uriBuilder.path("/vaga/{id}").buildAndExpand(vaga.getId()).toUri();
		return ResponseEntity.created(uri).body(vaga);
		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<Vaga> update(@PathVariable Long id, @RequestBody @Valid VagaForm form){
		Vaga vaga = vagaService.update(id, form);
		if(vaga != null) {
			return ResponseEntity.ok(vaga);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> delete(@PathVariable Long id){
		boolean deleted = vagaService.delete(id);
		if(deleted) {
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/candidatar")
	@Transactional
	public ResponseEntity<ProcessoDto> candidatar(@RequestBody @Valid ProcessoForm form, UriComponentsBuilder uriBuilder){
		ProcessoDto processoDto = vagaService.candidatar(form);
		
		URI uri = uriBuilder.path("/processo/{id}").buildAndExpand(processoDto.getId()).toUri();
		return ResponseEntity.created(uri).body(processoDto);	
		
	}
	
	
}
