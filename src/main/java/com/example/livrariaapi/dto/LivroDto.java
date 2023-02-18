package com.example.livrariaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LivroDto {

    private Long id;
    @NotEmpty
    @NotBlank
    private String titulo;
    @NotEmpty
    @NotBlank
    private String descricao;
    @NotEmpty
    @NotBlank
    private AutorDto autor;


}
