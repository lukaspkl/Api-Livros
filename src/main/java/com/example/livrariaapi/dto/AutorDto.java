package com.example.livrariaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutorDto {

    private Long id ;
    @NotEmpty
    private String nome;
    @NotEmpty
    private String sobrenome;
}
