package com.persistenciaJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.persistenciaJPA.model.Estado;
import com.persistenciaJPA.model.Pais;
import com.persistenciaJPA.model.Pessoa;

@Repository
public interface PessoaFisiscaRepository extends JpaRepository<Pessoa, Integer>{

//	salvarPais
}
