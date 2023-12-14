package com.web.springBoot.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	private Double nota;
	@Column( length = 10, nullable = false)
	private String status;
	
}
