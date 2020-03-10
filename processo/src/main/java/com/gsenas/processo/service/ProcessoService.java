package com.gsenas.processo.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gsenas.processo.form.ProcessoForm;
import com.gsenas.processo.model.Processo;
import com.gsenas.processo.model.Resultado;
import com.gsenas.processo.model.Status;
import com.gsenas.processo.repository.ProcessoRepository;

@Service
public class ProcessoService {
	
	@Autowired
	private ProcessoRepository processoRepository;

	public Processo create(@Valid ProcessoForm form) {
		Processo processo = new Processo(
				form.getVaga(),
				form.getCandidato(),
				form.getStatus(),
				form.getResultado()
				);
		processoRepository.save(processo);
		return processo;
	}

	public Processo findById(Long id) {
		Optional<Processo> optional = processoRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public Processo update(Long id, @Valid ProcessoForm form) {
		Optional<Processo> optional = processoRepository.findById(id);
		if(optional.isPresent()) {
			Processo processo = optional.get();
			processo.setVaga(form.getVaga());
			processo.setCandidato(form.getCandidato());
			processo.setStatus(Status.valueOf(form.getStatus()));
			processo.setResultado(Resultado.valueOf(form.getResultado()));
			return processo;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			processoRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

}
