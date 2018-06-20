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
	public void salvarEstadoPais(Pais paisEstado) {
		
		Pais p = new Pais();
		p.setNome(paisEstado.getNome());
		p.setIso(paisEstado.getIso());
		p.setEstado(paisEstado.getEstado());
		for (Estado estado : p.getEstado()) {
			estado.setPais(p);
		}
		
		
		testeModelRepository.save(p);
	}
}
