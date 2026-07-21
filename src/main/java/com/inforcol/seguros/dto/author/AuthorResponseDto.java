package com.inforcol.seguros.dto.author;

import java.util.List;

import com.inforcol.seguros.dto.book.BookSimpleDto;

import lombok.Data;

@Data
public class AuthorResponseDto {
    private Long id;
    private String name;
    private AuthorDetailDto authorDetail;
    private List<BookSimpleDto> books; // DTO que NO incluye nuevamente al autor
}
