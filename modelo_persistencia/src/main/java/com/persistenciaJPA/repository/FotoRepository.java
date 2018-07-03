package com.persistenciaJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.persistenciaJPA.model.Foto;
import com.persistenciaJPA.model.Produto;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Integer>{

	@Query("select f from Foto f"
			+ " where f.id = :id")
	Foto consultarFoto(@Param("id") int id);

}
