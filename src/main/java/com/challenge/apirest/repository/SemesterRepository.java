package com.challenge.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.apirest.models.Semester;

public interface SemesterRepository extends JpaRepository<Semester, Long>{

}
