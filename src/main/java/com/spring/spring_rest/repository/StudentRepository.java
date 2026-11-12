package com.spring.spring_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.spring_rest.entity.Student;

/**
 * Data access repository interface for managing {@link Student} for entities.
 * Provides standard CRUD and query operations via {@link JpaRepository}.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {}