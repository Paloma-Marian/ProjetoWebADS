package com.web.springBoot.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Turma {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	@Column( length = 50, nullable = false)
	private String nome;
	@Column( length = 10, nullable = false)
	private String status;
	
}
