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

import com.blockbuster.locadora_filmes.model.Filmes;
import com.blockbuster.locadora_filmes.repository.FilmesRepository;

@RestController
@RequestMapping("/filmes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FilmesController {
	
	@Autowired
	private FilmesRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Filmes>> findAllFilmes(){
		return ResponseEntity.ok(repository.findAll());
	}
	@GetMapping ("/{id}")
	public ResponseEntity<Filmes> findByIdFilmes(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	@PostMapping
	public ResponseEntity<Filmes> postFilmes(@RequestBody Filmes filmes){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(filmes));
	}
	@PutMapping
	public ResponseEntity<Filmes> putFilmes(@RequestBody Filmes filmes){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(filmes));
	}
	@DeleteMapping
	public void deleteFilmes(@PathVariable long id) {
		repository.deleteById(id);
	}

}
