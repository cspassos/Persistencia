package com.persistenciaJPA.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisica extends Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "rg", nullable = false, length = 10)
	private String rg;
	
	@CPF
	@Column(name = "cpf", nullable = false, length = 14)
	private String cpf;

	@Temporal(TemporalType.DATE)
	@Column(name = "nascimento", nullable = false)
	private Calendar nascimento;
	
	@Column(name = "nomeUsuario", nullable = false, length = 30, unique = true)
	private String nomeUsuario;
	
	@Column(name = "senha", nullable = false, length = 10)
	private String senha;
	
	public PessoaFisica() {
		super();
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Calendar getNascimento() {
		return nascimento;
	}
	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
