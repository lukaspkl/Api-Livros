package com.example.livrariaapi.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @NotEmpty
    @NotNull
    @Column(length = 150,nullable = false)
    private String nome;
    @NotEmpty
    @NotBlank
    @Column(length = 150, nullable = false)
    private String sobrenome;

    @OneToMany(mappedBy = "autor")
    List<Livro>livros;
}
