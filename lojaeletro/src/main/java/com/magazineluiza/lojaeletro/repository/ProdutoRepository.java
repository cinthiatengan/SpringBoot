package com.magazineluiza.lojaeletro.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.magazineluiza.lojaeletro.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	//public List<Produto> findAllByNomeContainingIgnoreCase(String nome);
	
	//por query do mysql:
	//@Query (value="select * from tb_produto where preco > :valor1 and preco < :valor2", nativeQuery=true)
	//public List<Produto> RangePreco(@Param("valor1") double valor1, @Param("valor2") double valor2);
	
	//metodo betweeen
	List<Produto> findAllByPrecoBetween(BigDecimal preco1, BigDecimal preco2);
}

