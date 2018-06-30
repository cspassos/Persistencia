package com.persistenciaJPA.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.br.CNPJ;

@Entity
@Table(name = "pessoa_juridica")
public class PessoaJuridica extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "ie", length = 15, nullable = false)
    private String ie;

    @CNPJ(message = "CNPJ inválido")
    @Column(name = "cnpj", length = 18, nullable = false)
    private String cnpj;

    public PessoaJuridica() {
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
