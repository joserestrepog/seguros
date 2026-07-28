package com.inforcol.seguros.dto.category;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryRequestDto {

    @NotBlank(message = "No puede ser blanco.")
    @Length(min = 3, max = 10)
    private String name;
}
