package com.inforcol.seguros.dto.book;

import java.util.List;

import lombok.Data;

@Data
public class BookRequestDto {
    private String title;
    private String isbn;
    private Double price;
    private Long authorId;          // ID del autor al que pertenece
    private List<Long> categoryIds;
}
