package com.gsenas.processo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gsenas.processo.model.Processo;

public interface ProcessoRepository extends JpaRepository<Processo, Long>{

}
