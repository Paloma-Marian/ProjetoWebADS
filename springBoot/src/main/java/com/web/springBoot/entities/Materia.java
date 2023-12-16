package com.web.springBoot.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "tb_materias")
public class Materia {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	@Column( length = 50, nullable = false)
	private String nome;
	@Column( length = 5 , nullable = false)
	private Double nota1;
	@Column( length = 10, nullable = false)
	private Double nota2;
	@Column( length = 10, nullable = false)
	private Double nota3;
	@Column( length = 10, nullable = false)
	private Double notafim;
	@Column( length = 10, nullable = false)
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;
	
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
	public Double getNota1() {
		return nota1;
	}
	public void setNota1(Double nota1) {
		this.nota1 = nota1;
	}
	public Double getNota2() {
		return nota2;
	}
	public void setNota2(Double nota2) {
		this.nota2 = nota2;
	}
	public Double getNota3() {
		return nota3;
	}
	public void setNota3(Double nota3) {
		this.nota3 = nota3;
	}
	public Double getNotafim() {
		return notafim;
	}
	public void setNotafim(Double notafim) {
		this.notafim = notafim;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	//Constructor
	public Materia(Long id, String nome, Double nota1, Double nota2, Double nota3, Double notafim, String status,
			Aluno aluno) {
		super();
		this.id = id;
		this.nome = nome;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
		this.notafim = notafim;
		this.status = status;
		this.aluno = aluno;
	}
}
