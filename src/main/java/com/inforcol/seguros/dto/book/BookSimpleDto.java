package com.inforcol.seguros.dto.book;

import lombok.Data;

@Data
public class BookSimpleDto {
    private Long id;
    private String title;
    private String isbn;
    private Double price;
}
