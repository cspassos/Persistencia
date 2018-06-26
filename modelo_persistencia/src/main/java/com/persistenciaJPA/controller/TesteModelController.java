package com.persistenciaJPA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.persistenciaJPA.DTO.EstadoPaisDTO;
import com.persistenciaJPA.model.Estado;
import com.persistenciaJPA.model.Pais;
import com.persistenciaJPA.service.testeEntity;

@Controller
@CrossOrigin("*")
@RequestMapping(value="/teste")
public class TesteModelController {

	@Autowired
	private testeEntity testeEntity;
	
	@RequestMapping(value="/salvar", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pais> buscaAleatoria(@RequestBody Pais pais){
		testeEntity.salvarPais(pais);
		return new ResponseEntity<Pais>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/salvarEstadoPais", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pais> salvarEstadoPais(@RequestBody Pais paisEstado){
		testeEntity.salvarEstadoPais(paisEstado);
		return new ResponseEntity<Pais>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/salvarPessoaFisica", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pais> salvarPessoaFisica(){
		testeEntity.salvarPessoaFisica();
		return new ResponseEntity<Pais>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/salvarEndereco", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pais> salvarEndereco(){
		testeEntity.salvarEndereco();
		return new ResponseEntity<Pais>(HttpStatus.OK);
	}
	
}
