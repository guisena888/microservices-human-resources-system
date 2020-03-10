package com.gsenas.vaga.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gsenas.vaga.model.Vaga;

public interface VagaRepository extends JpaRepository<Vaga, Long>{

	Page<Vaga> findByTitulo(String vagaTitulo, Pageable pagination);

}
