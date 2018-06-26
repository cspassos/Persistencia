package com.persistenciaJPA.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.persistenciaJPA.model.Estado;
import com.persistenciaJPA.model.Pais;
import com.persistenciaJPA.model.Pessoa;
import com.persistenciaJPA.model.PessoaFisica;

@Repository
public interface PessoaFisicaRepository extends JpaRepository<Pessoa, Integer>{

	

//	salvarPais
}
