package com.persistenciaJPA.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "parcela")
public class Parcela implements Serializable{

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ParcelaID parcelaID;
	
	@Column(name = "valor", nullable = false)
	private Double valor;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "vencimento", nullable = false)
	private Calendar vencimento;
	
	@Column(name = "valorPagamento")
	private Double valorPagamento;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dataPagamento")
	private Calendar dataPagamento;
	
	public Parcela() {
	}

	public ParcelaID getParcelaID() {
		return parcelaID;
	}
	public void setParcelaID(ParcelaID parcelaID) {
		this.parcelaID = parcelaID;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Calendar getVencimento() {
		return vencimento;
	}
	public void setVencimento(Calendar vencimento) {
		this.vencimento = vencimento;
	}
	public Double getValorPagamento() {
		return valorPagamento;
	}
	public void setValorPagamento(Double valorPagamento) {
		this.valorPagamento = valorPagamento;
	}
	public Calendar getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(Calendar dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parcelaID == null) ? 0 : parcelaID.hashCode());
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
		Parcela other = (Parcela) obj;
		if (parcelaID == null) {
			if (other.parcelaID != null)
				return false;
		} else if (!parcelaID.equals(other.parcelaID))
			return false;
		return true;
	}
}
