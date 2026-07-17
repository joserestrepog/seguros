package com.inforcol.seguros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inforcol.seguros.model.BookModel;

public interface BookRepository extends JpaRepository <BookModel, Long> {

}
