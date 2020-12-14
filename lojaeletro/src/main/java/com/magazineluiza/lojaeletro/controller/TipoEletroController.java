package com.magazineluiza.lojaeletro.controller;

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

import com.magazineluiza.lojaeletro.model.TipoEletro;
import com.magazineluiza.lojaeletro.repository.TipoEletroRepository;

@RestController
@RequestMapping("/tipoeletro")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TipoEletroController {
	
	@Autowired
	private TipoEletroRepository repository;
    
	@GetMapping
	public ResponseEntity<List<TipoEletro>> findAllEletro() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<TipoEletro> findByIdEletro(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<TipoEletro> postEletro(@RequestBody TipoEletro tipoeletro) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tipoeletro));
	}

	@PutMapping
	public ResponseEntity<TipoEletro> putEletro(@RequestBody TipoEletro tipoeletro) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(tipoeletro));
	}

	@DeleteMapping("/{id}")
	public void deleteEletro(@PathVariable long id) {
		repository.deleteById(id);
	}
}
