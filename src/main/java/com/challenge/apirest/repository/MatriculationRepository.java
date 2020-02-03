package com.challenge.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.apirest.models.Matriculation;

public interface MatriculationRepository extends JpaRepository<Matriculation, Long> {

}
