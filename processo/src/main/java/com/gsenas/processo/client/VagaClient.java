package com.gsenas.processo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gsenas.processo.dto.VagaDto;

@FeignClient(name = "vaga")
public interface VagaClient {
	
	@RequestMapping("/vaga/{id}")
	VagaDto findById(@PathVariable Long id);
	
	

}
