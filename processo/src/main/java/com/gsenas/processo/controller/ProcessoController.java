package com.gsenas.processo.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gsenas.processo.form.ProcessoForm;
import com.gsenas.processo.model.Processo;
import com.gsenas.processo.service.ProcessoService;

@RestController
@RequestMapping("/processo")
public class ProcessoController {
	
	@Autowired
	private ProcessoService processoService;
	
	@GetMapping("/{id}")
	private ResponseEntity<Processo> findById(@PathVariable Long id){
		Processo processo = processoService.findById(id);
		if(processo != null) {
			return ResponseEntity.ok(processo);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@Transactional
	private ResponseEntity<Processo> create(@RequestBody @Valid ProcessoForm form, UriComponentsBuilder uriBuilder){
		
		Processo processo = processoService.create(form);
		URI uri = uriBuilder.path("/processo/{id}").buildAndExpand(processo.getId()).toUri();
		return ResponseEntity.created(uri).body(processo);	
	}
	
	@PutMapping("/{id}")
	private ResponseEntity<Processo> update(@PathVariable Long id, @RequestBody @Valid ProcessoForm form){
		Processo processo = processoService.update(id, form);
		if(processo != null) {
			return ResponseEntity.ok(processo);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	private ResponseEntity<?> delete(@PathVariable Long id){
		boolean isDeleted = processoService.delete(id);
		if(isDeleted) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
