package com.persistenciaJPA.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.persistenciaJPA.model.Pais;
import com.persistenciaJPA.service.TesteEntity;

@Controller
@CrossOrigin("*")
@RequestMapping(value="/teste")
public class TesteModelController {

	@Autowired
	private TesteEntity testeEntity;
	
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
	
	@RequestMapping(value="/salvarProduto", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pais> salvarProduto(){
		testeEntity.salvarProduto();
		return new ResponseEntity<Pais>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/salvarVenda", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pais> salvarVenda(){
		testeEntity.salvarVenda();
		return new ResponseEntity<Pais>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/salvarParcelas", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pais> salvarParcelas(){
		testeEntity.salvarParcelas();
		return new ResponseEntity<Pais>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/salvarFoto", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pais> salvarFoto() throws IOException{
		testeEntity.salvarFoto();
		return new ResponseEntity<Pais>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/visualizarFoto", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pais> visualizarFoto() throws IOException{
		testeEntity.visualizarFoto();
		return new ResponseEntity<Pais>(HttpStatus.OK);
	}
	
}
