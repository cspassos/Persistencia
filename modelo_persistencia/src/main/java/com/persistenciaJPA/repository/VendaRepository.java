package com.persistenciaJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.persistenciaJPA.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer>{

}
