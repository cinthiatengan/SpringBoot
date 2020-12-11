package com.blockbuster.locadora_filmes.controller;

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

import com.blockbuster.locadora_filmes.model.Servico;
import com.blockbuster.locadora_filmes.repository.ServicoRepository;

@RestController
@RequestMapping("/servico")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ServicoController {

	@Autowired
	private ServicoRepository repository;

	@GetMapping
	public ResponseEntity<List<Servico>> findAllServico() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Servico> findByIdServico(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Servico> postServico(@RequestBody Servico servico) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(servico));
	}

	@PutMapping
	public ResponseEntity<Servico> putServico(@RequestBody Servico servico) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(servico));
	}

	@DeleteMapping("/{id}")
	public void deleteServico(@PathVariable long id) {
		repository.deleteById(id);
	}

}
