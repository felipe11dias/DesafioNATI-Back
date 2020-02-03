package com.challenge.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.apirest.models.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
