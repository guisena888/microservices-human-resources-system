package com.gsenas.candidato.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gsenas.candidato.model.Candidato;

public interface CandidatoRepository extends JpaRepository<Candidato, Long>{

	Optional<Candidato> findById(Long id);

}
