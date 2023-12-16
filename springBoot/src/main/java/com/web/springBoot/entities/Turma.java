package com.web.springBoot.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "tb_turmas")
public class Turma {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	@Column( length = 50, nullable = false)
	private String nome;
	@Column( length = 1, nullable = false)
	private Integer semestre;
	@Column( length = 1, nullable = false)
	private Integer data;
	@Column( length = 10, nullable = false)
	private String status;
	@ManyToOne
	private Aluno alunos;
	
	//Getters e Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getSemestre() {
		return semestre;
	}
	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}
	public Integer getData() {
		return data;
	}
	public void setData(Integer data) {
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Aluno getAlunos() {
		return alunos;
	}
	public void setAlunos(Aluno alunos) {
		this.alunos = alunos;
	}
	
	//Constructor
	public Turma(Long id, String nome, Integer semestre, Integer data, String status, Aluno alunos) {
		super();
		this.id = id;
		this.nome = nome;
		this.semestre = semestre;
		this.data = data;
		this.status = status;
		this.alunos = alunos;
	}
}
