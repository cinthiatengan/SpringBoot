package com.blockbuster.locadora_filmes.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_servico")
public class Servico {

	// attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	private String midia;
	@NotNull
	private String descricao;
	@NotNull
	private BigDecimal valor;

	// relationship between tables
	@OneToMany(mappedBy = "servico", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("servico")
	private List<Filmes> filmes;

	// getters and setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMidia() {
		return midia;
	}

	public void setMidia(String midia) {
		this.midia = midia;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public List<Filmes> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filmes> filmes) {
		this.filmes = filmes;
	}

}
