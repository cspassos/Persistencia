package com.persistenciaJPA.service;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.persistenciaJPA.model.Categoria;
import com.persistenciaJPA.model.Endereco;
import com.persistenciaJPA.model.Estado;
import com.persistenciaJPA.model.Marca;
import com.persistenciaJPA.model.Pais;
import com.persistenciaJPA.model.Pessoa;
import com.persistenciaJPA.model.PessoaFisica;
import com.persistenciaJPA.model.Produto;
import com.persistenciaJPA.model.Venda;
import com.persistenciaJPA.model.VendaItens;
import com.persistenciaJPA.repository.PessoaRepository;
import com.persistenciaJPA.repository.ProdutoRepository;
import com.persistenciaJPA.repository.TesteModelRepository;
import com.persistenciaJPA.repository.VendaRepository;

@Service
public class TesteEntity {

	@Autowired
	private TesteModelRepository testeModelRepository;
	
	@Autowired 
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository; 
	
	@Autowired
	private VendaRepository vendaRepository;
	@Transactional
	public void salvarPais(Pais pais){
//		testeModelRepository.save(pais);
	}
	
	//relacionamento com herança
	@Transactional
	public void salvarPessoaFisica() {
		
		PessoaFisica p = dadosPessoaFisica();
		
		pessoaRepository.save(p);
	}
	
	public PessoaFisica dadosPessoaFisica() {
		
		PessoaFisica p = new PessoaFisica();
		
		p.setCpf("995.304.594-16");
		p.setEmail("teste.so@hotmail.com");
		p.setNascimento(Calendar.getInstance());
		p.setNome("Carlos Souza");
		p.setNomeUsuario("Souza Passos");
		p.setRg("1232133");
		p.setSenha("213213");
		p.setTelefone("(61)2133-1223");
		
		return p;
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

	@Transactional
	public void salvarProduto() {
		Produto p = new Produto();
		
		p.setNome("Bola");
		p.setDescricao("Bola 81");
		p.setPreco(12.2);
		p.setQuantidadeEstoque(10.1);
		
		p.setCategoria(adicionarCategoria());
		p.setMarca(adicionarMarca());
	
		p.setDesejam(adicionarPessoasFisica());
		
		produtoRepository.save(p);
	}
	
	public Produto adicionarProduto() {
		Produto p = new Produto();
		
		p.setNome("Bola");
		p.setDescricao("Bola 81");
		p.setPreco(12.2);
		p.setQuantidadeEstoque(10.1);
		
		p.setCategoria(adicionarCategoria());
		p.setMarca(adicionarMarca());
	
		p.setDesejam(adicionarPessoasFisica());
		return p;
	}

	private List<PessoaFisica> adicionarPessoasFisica() {
		List<PessoaFisica> pessoas = new ArrayList<>();
		pessoas.add(dadosPessoaFisica());
		
		return pessoas;
	}

	private Marca adicionarMarca() {
		Marca m = new Marca();
		m.setNome("Nike");
		return m;
	}

	private Categoria adicionarCategoria() {
		Categoria c = new Categoria();
		c.setNome("ESPORTE");
		return c;
	}

	@Transactional
	public void salvarVenda() {
		PessoaFisica pf = pessoaRepository.buscarPessoaFisica2("1232133");
		Venda v = new Venda();
		
		v.setData(Calendar.getInstance());
		v.setParcelas(3);
		v.setPessoaFisica(pf);
		v.setVendaItens(adicionarItens());
		for (VendaItens item : v.getVendaItens()) {
			item.setVenda(v);
		}
		
		vendaRepository.save(v);
//		for (VendaItens item : v.getVendaItens()) {
//			v.adicionarItens(item);
//		}
		
	}

	private List<VendaItens> adicionarItens() {
		List<VendaItens> itens = new ArrayList<>();
		VendaItens i = new VendaItens();
		Produto p = produtoRepository.consultarProduto(1);

		i.setProduto(p);
		i.setQuantidade(5.0);
		i.setValorUnitario(i.getProduto().getPreco());
		i.setValorToal(i.getQuantidade() * i.getValorUnitario());
		
		itens.add(i);
		
		return itens;
	}
}
