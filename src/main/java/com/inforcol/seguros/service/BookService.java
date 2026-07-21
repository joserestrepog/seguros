package com.inforcol.seguros.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.inforcol.seguros.dto.book.BookRequestDto;
import com.inforcol.seguros.dto.book.BookResponseDto;
import com.inforcol.seguros.dto.category.CategoryResponseDto;
import com.inforcol.seguros.model.Author;
import com.inforcol.seguros.model.Category;
import com.inforcol.seguros.repository.AuthorRepository;
import com.inforcol.seguros.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inforcol.seguros.model.Book;
import com.inforcol.seguros.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BookMapper bookMapper;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookResponseDto createBook(BookRequestDto dto) {
        // 1. Buscar al Autor
        Author author = authorRepository.findById(dto.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Autor no encontrado con ID: " + dto.getAuthorId()));

        // 2. Buscar las Categorías
        List<Category> categories = categoryRepository.findAllById(dto.getCategoryIds());

        // 3. Crear entidad y asignar relaciones
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setIsbn(dto.getIsbn());
        book.setPrice(dto.getPrice());
        book.setAuthor(author);
        book.setCategories(categories);

        return bookMapper.toDto(bookRepository.save(book));
    }

    public List<BookResponseDto> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }

    public BookResponseDto getBookById(Long id) {
        return bookRepository.findById(id)
                .map(bookMapper::toDto)
                .orElseThrow(() -> new RuntimeException("book not found with ID: " + id));
    }

    public BookResponseDto updateBook(Long id, BookRequestDto dto) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("book not found with ID: " + id));

        Author author = authorRepository.findById(dto.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author not found with ID: " + dto.getAuthorId()));

        List<Category> categories = categoryRepository.findAllById(dto.getCategoryIds());

        existingBook.setTitle(dto.getTitle());
        existingBook.setIsbn(dto.getIsbn());
        existingBook.setPrice(dto.getPrice());
        existingBook.setAuthor(author);
        existingBook.setCategories(categories);

        return bookMapper.toDto(bookRepository.save(existingBook));
    }

    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("book not found with ID: " + id));
        bookRepository.delete(book);
    }

}
