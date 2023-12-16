package com.web.springBoot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.springBoot.entities.Turma;
import com.web.springBoot.repository.TurmaRepository;


@RestController
@RequestMapping(value = "/turmas")
public class TurmaController {
	
	@Autowired
	TurmaRepository repositorioTurma;
	
	@GetMapping
	public ResponseEntity<List<Turma>> getBuscaTodasTurmas() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(repositorioTurma.findAll());	
		} catch (Exception exception_BuscaTodosTurmas) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Turma> getBuscaTurma(@PathVariable("id") Long id){
		Optional<Turma> optionalTurma = repositorioTurma.findById(id);
		try {
			Turma turma_aux = optionalTurma.get();
			return ResponseEntity.status(HttpStatus.OK).body(turma_aux);
		} catch (Exception exception_BuscaTurma) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PostMapping()
	public ResponseEntity<Turma> postInserirTurma(@RequestBody Turma turma) {
		try {
			Turma turma_aux = repositorioTurma.save(turma);
			return ResponseEntity.status(HttpStatus.CREATED).body(turma_aux);	
		} catch (Exception exception_InserirTurma) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PutMapping("/{id_turma}")
	public ResponseEntity<Turma> putAlterarTurma(@PathVariable("id_turma")Long id_turma, @RequestBody Turma turma){
		Optional<Turma> optionalTurma = repositorioTurma.findById(id_turma);
		try {
			Turma turma_aux = optionalTurma.get();
			turma_aux.setNome(turma.getNome());
			turma_aux.setSemestre(turma.getSemestre());
			turma_aux.setData(turma.getData());
			turma_aux.setAlunos(turma.getAlunos());
			turma_aux.setStatus(turma.getStatus());
			return ResponseEntity.status(HttpStatus.OK).body(turma_aux);
		}catch (Exception exception_AlterarTurma){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Turma> deleteTurma(@PathVariable("id") Long id){
		Optional<Turma> optionalTurma = repositorioTurma.findById(id);
		try {
			Turma materia_aux = optionalTurma.get();
			repositorioTurma.delete(materia_aux);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception exception_deleteTurma) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
