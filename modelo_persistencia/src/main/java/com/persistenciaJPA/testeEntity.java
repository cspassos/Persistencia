package com.persistenciaJPA;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.persistenciaJPA.DTO.EstadoPaisDTO;
import com.persistenciaJPA.model.Estado;
import com.persistenciaJPA.model.Pais;
import com.persistenciaJPA.repository.TesteModelRepository;

@Service
public class testeEntity {

	
	@Autowired
	private TesteModelRepository testeModelRepository;
	
	@Transactional
	public void salvarPais(Pais pais){
//		testeModelRepository.save(pais);
	}
	
	@Transactional
	public void salvarEstadoPais(EstadoPaisDTO estado) {
		Estado e = new Estado();
		
		e.setNome(estado.getNomeEstado());
		e.setUf(estado.getUf());
		e.setPais(new Pais());
		e.getPais().setNome(estado.getNomePais());
		e.getPais().setIso(estado.getIso());
		
		testeModelRepository.save(e);
	}
}
