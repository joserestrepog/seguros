package com.inforcol.seguros.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inforcol.seguros.model.BookModel;

@Repository
public interface BookRepository extends JpaRepository <BookModel, Long> {
    Optional<BookModel> findByTitulo(String titulo);
}
