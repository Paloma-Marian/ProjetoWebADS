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

import com.web.springBoot.entities.Materia;
import com.web.springBoot.repository.MateriaRepository;

@RestController
@RequestMapping(value = "/materias")
public class MateriaController {
	
	@Autowired
	MateriaRepository repositorioMateria;
	
	@GetMapping
	public ResponseEntity<List<Materia>> getBuscaTodosMaterias() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(repositorioMateria.findAll());	
		} catch (Exception exception_BuscaTodosMaterias) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Materia> getBuscaMateria(@PathVariable("id") Long id){
		Optional<Materia> optionalMateria = repositorioMateria.findById(id);
		try {
			Materia materia_aux = optionalMateria.get();
			return ResponseEntity.status(HttpStatus.OK).body(materia_aux);
		} catch (Exception exception_BuscaMateria) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PostMapping()
	public ResponseEntity<Materia> postInserirMateria(@RequestBody Materia materia) {
		try {
			Materia materia_aux = repositorioMateria.save(materia);
			return ResponseEntity.status(HttpStatus.CREATED).body(materia_aux);	
		} catch (Exception exception_InserirMateria) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PutMapping("/{id_materia}")
	public ResponseEntity<Materia> putAlterarMateria(@PathVariable("id_materia")Long id_Materia, @RequestBody Materia materia){
		Optional<Materia> optionalMateria = repositorioMateria.findById(id_Materia);
		try {
			Materia materia_aux = optionalMateria.get();
			materia_aux.setNome(materia.getNome());
			materia_aux.setNota1(materia.getNota1());
			materia_aux.setNota2(materia.getNota2());
			materia_aux.setNota3(materia.getNota3());
			materia_aux.setNotafim(materia.getNotafim());
			materia_aux.setAluno(materia.getAluno());
			materia_aux.setStatus(materia.getStatus());
			return ResponseEntity.status(HttpStatus.OK).body(materia_aux);
		}catch (Exception exception_AlterarMateria){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Materia> deleteMateria(@PathVariable("id") Long id){
		Optional<Materia> optionalMateria = repositorioMateria.findById(id);
		try {
			Materia materia_aux = optionalMateria.get();
			repositorioMateria.delete(materia_aux);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception exception_deleteMateria) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
