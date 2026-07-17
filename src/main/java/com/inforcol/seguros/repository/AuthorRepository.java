package com.inforcol.seguros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inforcol.seguros.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
