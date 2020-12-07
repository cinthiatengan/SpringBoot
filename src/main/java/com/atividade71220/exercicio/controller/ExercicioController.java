package com.atividade71220.exercicio.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mentalidade1")
	public class ExercicioController {
	@GetMapping 
	public String mentalidade1() {
		return "Uma mentalidade que venho desenvolvendo muito na Generation é a de crescimento, "
				+ "\npois a cada dia me planejo melhor e consigo enxergar meu futuro após o fim do curso.";
	}

	@GetMapping("/mentalidade2") // criando uma subrota
	public String mentalidade2() {
		return "Outra mentalidade que a Generation me ajudou muito a desenvolver é a de Responsabilidade Pessoal"
				+ "\npois cabe a mim mesmo ter responsabilidade de estudar para dar um bom prosseguimento ao curso.";
	}
	@GetMapping("/habilidade1") //subrota 2
	public String habilidade1() {
		return "Já em habilidades, a persistência se mostrou uma habilidade muito importante para não"
				+ "\ndesistirmos de nossos objetivos perante qualquer obstáculo.";
	}
	@GetMapping("/habilidade2") //subrota 3
	public String habilidade2() {
		return "Por ultimo, acredito muito que minha habilidade de comunicação tenha se aprimorado durante o curso"
				+ "\npois me sinto mais a vontade de conversar com meus colegas e pedir ajuda quando necessito.";
	}
	
}
