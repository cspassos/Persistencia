package com.persistenciaJPA.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer prod_id;
	
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "descricao", columnDefinition = "text")
	private String descricao;
	
	@Column(name = "preco")
	private Double preco;
	
	@Column(name = "quantidade_estoque", nullable = false)
	private Double quantidadeEstoque;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "categoria", referencedColumnName = "cat_id")
	private Categoria categoria;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "marca", referencedColumnName = "mar_id")
	private Marca marca;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "produto_pessoa_fisica", joinColumns = {
				@JoinColumn(name = "prod_id", nullable = false, updatable = false) },
			inverseJoinColumns = {
				@JoinColumn(name = "id", nullable = false, updatable = false) }
		)
	private List<PessoaFisica> desejam;
	
	public Produto() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Double getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Double quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public List<PessoaFisica> getDesejam() {
		return desejam;
	}

	public void setDesejam(List<PessoaFisica> desejam) {
		this.desejam = desejam;
	}

	public Integer getProd_id() {
		return prod_id;
	}

	public void setProd_id(Integer prod_id) {
		this.prod_id = prod_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((prod_id == null) ? 0 : prod_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (prod_id == null) {
			if (other.prod_id != null)
				return false;
		} else if (!prod_id.equals(other.prod_id))
			return false;
		return true;
	}
}
