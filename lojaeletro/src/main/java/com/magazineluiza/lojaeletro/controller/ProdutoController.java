package com.magazineluiza.lojaeletro.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magazineluiza.lojaeletro.model.Produto;
import com.magazineluiza.lojaeletro.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAllProduto() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> findByIdProduto(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	/*@GetMapping("/{valor1}/{valor2}")
	public ResponseEntity<List<Produto>> GetAllByRange(@PathVariable double valor1, @PathVariable double valor2){
		return ResponseEntity.ok(repository.RangePreco(valor1, valor2));
	}*/ // por query do MySQL (desafio 1)
	
	@GetMapping("/range/{preco1}/{preco2}") // por metodo between (desafio 1)
	public ResponseEntity <List<Produto>> GetAllByRange(@PathVariable BigDecimal preco1, @PathVariable BigDecimal preco2){
		return ResponseEntity.ok(repository.findAllByPrecoBetween(preco1, preco2));	
	}
	@GetMapping("porTipo/{tipoId}/{valor}")// por query (desafio 2)
	public ResponseEntity <List<Produto>> GetAllRangesByType(@PathVariable int tipoId, @PathVariable double valor){
		return ResponseEntity.ok(repository.RangePrecoTipo(tipoId, valor));
	}

	@PostMapping
	public ResponseEntity<Produto> postProduto(@RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}

	@PutMapping
	public ResponseEntity<Produto> putProduto(@RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
	}

	@DeleteMapping("/{id}")
	public void deleteProduto(@PathVariable long id) {
		repository.deleteById(id);
	}

}
