package com.magazineluiza.lojaeletro.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produto")
public class Produto {

	// attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	@Size(max = 500)
	@Column(name = "Nome")
	private String nome;
	@NotNull
	@Column(name = "Quantidade")
	private int quantidade;
	@NotNull
	@Column(name = "Valor")
	private BigDecimal preco;

	// relationship between tables Produto N ---- 1 Categoria
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;

	// Produto N ------ 1 TipoEletro
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private TipoEletro tipoeletro;

	// getters and setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

}
