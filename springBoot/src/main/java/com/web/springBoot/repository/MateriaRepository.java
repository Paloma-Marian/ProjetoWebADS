package com.web.springBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.web.springBoot.entities.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long> {

}
