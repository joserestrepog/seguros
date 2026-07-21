package com.inforcol.seguros.dto.book;

import java.util.List;

import com.inforcol.seguros.dto.category.CategoryDto;

import lombok.Data;

@Data
public class BookResponseDto {
    private Long id;
    private String title;
    private String isbn;
    private Double price;
    private String authorName; // Aplanamos la información del autor
    private List<CategoryDto> categories;
}
