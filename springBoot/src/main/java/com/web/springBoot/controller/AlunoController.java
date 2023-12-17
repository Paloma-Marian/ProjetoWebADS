package com.web.springBoot.controller;

import java.util.List;
import java.util.Optional;

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

import com.web.springBoot.entities.Aluno;
import com.web.springBoot.repository.AlunoRepository;

@CrossOrigin
@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {

	@Autowired
	AlunoRepository repositorioAluno;
	
	@GetMapping()
	public ResponseEntity<List<Aluno>> getBuscaTodosAlunos() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(repositorioAluno.findAll());	
		} catch (Exception exception_BuscaTodosAlunos) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Aluno> getBuscaAluno(@PathVariable("id") long id){
		Optional<Aluno> optionalAluno = repositorioAluno.findById(id);
		try {
			Aluno aluno_aux = optionalAluno.get();
			return ResponseEntity.status(HttpStatus.OK).body(aluno_aux);
		} catch (Exception exception_BuscaAluno) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PostMapping()
	public ResponseEntity<Aluno> postInserirAluno(@RequestBody Aluno aluno){
		try {
			Aluno aluno_aux = repositorioAluno.save(aluno);
			return ResponseEntity.status(HttpStatus.CREATED).body(aluno_aux);	
		} catch (Exception exception_InserirAluno) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PutMapping("/{id_aluno}")
	public ResponseEntity<Aluno> putAlterarAluno(@PathVariable("id_aluno")Long id_aluno, @RequestBody Aluno aluno){
		Optional<Aluno> optionalAluno = repositorioAluno.findById(id_aluno);
		try {
			Aluno aluno_aux = optionalAluno.get();
			aluno_aux.setNome(aluno.getNome());
			aluno_aux.setCpf(aluno.getCpf());
			aluno_aux.setEmail(aluno.getEmail());
			aluno_aux.setStatus(aluno.getStatus());
			repositorioAluno.save(aluno_aux);
			return ResponseEntity.status(HttpStatus.OK).body(aluno_aux);
		} catch (Exception exception_AlterarAluno) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Aluno> deleteAluno(@PathVariable("id") Long id){
		Optional<Aluno> optionalAluno = repositorioAluno.findById(id);
		try {
			Aluno aluno_aux = optionalAluno.get();
			repositorioAluno.delete(aluno_aux);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception exception_deleteAluno) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
