package com.persistenciaJPA.service;


import java.util.Calendar;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.persistenciaJPA.model.Endereco;
import com.persistenciaJPA.model.Estado;
import com.persistenciaJPA.model.Pais;
import com.persistenciaJPA.model.Pessoa;
import com.persistenciaJPA.model.PessoaFisica;
import com.persistenciaJPA.repository.PessoaFisicaRepository;
import com.persistenciaJPA.repository.PessoaRepository;
import com.persistenciaJPA.repository.TesteModelRepository;

@Service
public class testeEntity {

	@Autowired
	private EntityManager emf;
	
	@Autowired
	private TesteModelRepository testeModelRepository;
	
	@Autowired 
	private PessoaRepository pessoaRepository;
	
	@Transactional
	public void salvarPais(Pais pais){
//		testeModelRepository.save(pais);
	}
	
	//relacionamento com herança
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
		
		pessoaRepository.save(p);
	}
	
	@Transactional
	public void salvarEndereco() {
		Pessoa pf = pessoaRepository.buscarPessoaFisica(1);
		Endereco e = new Endereco();
		e.setBairro("Centro");
		e.setCep("9962-32");
		e.setComplemento("Ap 21");
		e.setEndereco("Guariroba");
		e.setNickname("casa");
		e.setNumero("123");
		e.setReferencias("perto da");
		
		pf.adicionarEndereco(e);
		
		pessoaRepository.save(pf);
	}
	
	//relacionamento um para muitos
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
