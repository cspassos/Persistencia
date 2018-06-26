package com.persistenciaJPA.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "marca")
public class Marca implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mar_id;
	@Column(name = "nome", length = 40, nullable = false)
	private String nome;

	public Marca() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getMar_id() {
		return mar_id;
	}

	public void setMar_id(Integer mar_id) {
		this.mar_id = mar_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mar_id == null) ? 0 : mar_id.hashCode());
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
		Marca other = (Marca) obj;
		if (mar_id == null) {
			if (other.mar_id != null)
				return false;
		} else if (!mar_id.equals(other.mar_id))
			return false;
		return true;
	}
}
