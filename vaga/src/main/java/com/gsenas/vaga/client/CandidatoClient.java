package com.gsenas.vaga.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gsenas.vaga.dto.CandidatoDto;

@FeignClient(name = "candidato")
public interface CandidatoClient {

	@RequestMapping("/candidato/{id}")
	CandidatoDto findById(@PathVariable Long id);
}
