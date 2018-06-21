package com.persistenciaJPA.service;


import java.util.Calendar;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.persistenciaJPA.model.Estado;
import com.persistenciaJPA.model.Pais;
import com.persistenciaJPA.model.PessoaFisica;
import com.persistenciaJPA.repository.PessoaFisiscaRepository;
import com.persistenciaJPA.repository.TesteModelRepository;

@Service
public class testeEntity {

	@Autowired
	private EntityManager emf;
	
	@Autowired
	private TesteModelRepository testeModelRepository;
	
	@Autowired 
	private PessoaFisiscaRepository pessoaFisiscaRepository; 
	
	@Transactional
	public void salvarPais(Pais pais){
//		testeModelRepository.save(pais);
	}
	
	@Transactional
	public void salvarPessoaFisica() {
		PessoaFisica p = new PessoaFisica();
		
		p.setCpf("995.304.594-16");
		p.setEmail("teste.so@hotmail.com");
		p.setNascimento(Calendar.getInstance());
		p.setNome("Carlos Souza");
		p.setNomeUsuario("Souza Passos");
		p.setRg("1232133");
		p.setSenha("213213");
		p.setTelefone("(61)2133-1223");
		
		pessoaFisiscaRepository.save(p);
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
