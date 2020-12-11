package org.escola.diretoria.controller;

import java.util.List;

import org.escola.diretoria.model.Turma;
import org.escola.diretoria.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/turma")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class TurmaController {
	@Autowired
	private TurmaRepository repository;
	//first method
	@GetMapping
	public ResponseEntity<List<Turma>> findAllTurma(){
		return ResponseEntity.ok(repository.findAll());
	}
	//second method
	@GetMapping("/{id}")
	public ResponseEntity<Turma> findByIdTurma(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	//third method
	@PostMapping
	public ResponseEntity<Turma> postTurma(@RequestBody Turma turma){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(turma));
	}
	//fourth method
	@PutMapping
	public ResponseEntity<Turma> putTurma(@RequestBody Turma turma){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(turma));
	}
	@DeleteMapping("/{id}")
	public void deleteTurma(@PathVariable long id) {
		repository.deleteById(id);
	}
}
