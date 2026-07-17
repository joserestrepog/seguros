package com.inforcol.seguros.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inforcol.seguros.model.BookModel;
import com.inforcol.seguros.repository.BookRepository;

@Service
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;

    public BookModel createBook(BookModel bookModel){
        return this.bookRepository.save(bookModel);
    }

    public List<BookModel> getBooks() {
        return bookRepository.findAll();
    }

    public Optional<BookModel> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Optional<BookModel> getBookByTitulo(String titulo) {
        return bookRepository.findByTitulo(titulo);
    }

    public BookModel updateBook(Long id, BookModel newBookData) {
        BookModel bookModel = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));

        bookModel.setTitulo(newBookData.getTitulo());
        bookModel.setCodigo(newBookData.getCodigo());
        return bookRepository.save(bookModel);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }


}
