package com.persistenciaJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.persistenciaJPA.model.Pessoa;
import com.persistenciaJPA.model.PessoaFisica;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

	@Query("select p from Pessoa p"
			+ " where p.id = :id")
	Pessoa buscarPessoaFisica(@Param("id") Integer id);
	
	@Query("select p from PessoaFisica p"
			+ " where p.rg = :rg")
	PessoaFisica buscarPessoaFisica2(@Param("rg") String rg);
//	salvarPais
}
