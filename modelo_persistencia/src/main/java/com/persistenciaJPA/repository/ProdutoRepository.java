package com.persistenciaJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.persistenciaJPA.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

	@Query("select p from Produto p"
			+ " where p.prod_id = :prod_id")
	Produto consultarProduto(@Param("prod_id") int prod_id);

}
