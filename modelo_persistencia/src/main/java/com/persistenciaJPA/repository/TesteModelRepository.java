package com.persistenciaJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.persistenciaJPA.model.Estado;
import com.persistenciaJPA.model.Pais;

@Repository
public interface TesteModelRepository extends JpaRepository<Pais, Integer>{

//	salvarPais
}
