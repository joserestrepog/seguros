package com.inforcol.seguros.dto.author;

import java.time.LocalDate;

import lombok.Data;

@Data
public class AuthorDetailDto {
    private Long id;
    private String biography;
    private LocalDate birthDate;
    private String nationality;
}

