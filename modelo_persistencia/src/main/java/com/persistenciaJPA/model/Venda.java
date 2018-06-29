package com.persistenciaJPA.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "venda")
public class Venda implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data", nullable = false)
	private Calendar data;
	
	@Column(name = "valorTotal", nullable = false)
	private Double valorTotal;
	
	@Column(name = "parcelas", nullable = false)
	private Integer parcelas;
	
	@ManyToOne
	@JoinColumn(name = "pessoaFisica", referencedColumnName = "id")
	private PessoaFisica pessoaFisica;

	//orphanRemoval = remover os orfãos caso remova o pai
	@OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = false)
	private List<VendaItens> vendaItens;
	
	@OneToMany(mappedBy = "parcelaID.venda", cascade = CascadeType.ALL)
	private List<Parcela> listaParcelas;
	
	public void gerarParcelas() {
		Double valorParcela =this.valorTotal / this.parcelas;
		for (int i = 1; i <= this.parcelas; i++) {
			Parcela p = new Parcela();
			ParcelaID id = new ParcelaID();
			id.setNumero(i);
			id.setVenda(this);
			p.setParcelaID(id);
			p.setValor(valorParcela);
			Calendar vencimento = (Calendar) this.data.clone();
			vencimento.add(Calendar.MONTH, i);
			p.setVencimento(vencimento);
			this.listaParcelas.add(p);
		}
	}
	
	public void adicionarItens(VendaItens obj) {
		obj.setVenda(this);
		this.valorTotal =+ obj.getValorToal();
		this.vendaItens.add(obj);
	}
	
	public void removerItens(int index) {
		VendaItens obj = this.vendaItens.get(index);
		this.valorTotal -= obj.getValorToal();
		this.vendaItens.remove(index);
	}
	
	
	public Venda(){
		this.valorTotal = 0.0;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Integer getParcelas() {
		return parcelas;
	}
	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}
	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}
	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Venda other = (Venda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public List<VendaItens> getVendaItens() {
		return vendaItens;
	}

	public void setVendaItens(List<VendaItens> vendaItens) {
		this.vendaItens = vendaItens;
	}

	public List<Parcela> getListaParcelas() {
		return listaParcelas;
	}

	public void setListaParcelas(List<Parcela> listaParcelas) {
		this.listaParcelas = listaParcelas;
	}
}
