package com.inforcol.seguros.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inforcol.seguros.dto.AuthorDTO;
import com.inforcol.seguros.model.Author;
import com.inforcol.seguros.repository.AuthorRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public AuthorDTO createAuthor(AuthorDTO authorDTO) {

        Author author = new Author();
        author.setName(authorDTO.getNameAuthor());
        author.setCountry(authorDTO.getCountryAuthor());

        authorRepository.save(author);

        return AuthorDTO.builder()
                .nameAuthor(author.getName())
                .countryAuthor(author.getCountry())
                .build();
    }
}