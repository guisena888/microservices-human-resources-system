package com.gsenas.vaga.client;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gsenas.vaga.dto.ProcessoDto;
import com.gsenas.vaga.form.ProcessoForm;

@FeignClient(name = "processo")
public interface ProcessoClient {
	
	@RequestMapping(method = RequestMethod.POST, value = "/processo")
	ProcessoDto create(@RequestBody @Valid ProcessoForm form);

}
