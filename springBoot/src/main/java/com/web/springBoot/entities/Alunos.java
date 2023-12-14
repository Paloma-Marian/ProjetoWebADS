package com.web.springBoot.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "tb_alunos")
public class Alunos {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	@Column( length = 50, nullable = false)
	private String nome;
	@Column( length = 11 , nullable = false)
	private Integer cpf;
	@Column( length = 50, nullable = false)
	private String email;
	@Column( length = 10, nullable = false)
	private String status;
}
