package com.persistenciaJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.persistenciaJPA.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer>{

	@Query("select v from Venda v"
			+ " where v.id = :id")
	Venda buscarVenda(@Param("id") int i);

}
