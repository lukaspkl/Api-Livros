package com.example.livrariaapi.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Column(length = 200, nullable = false)
    private String titulo;
    @NotEmpty
    @Column(nullable = false)
    private String descricao;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_autor")
    private Autor autor;

    public void validarCampos() {
        if (isEmptyOrNull(this.titulo) || isEmptyOrNull(this.descricao) ) {
            throw new IllegalArgumentException("Título e descrição devem ser preenchidos");
        }
    }
    private boolean isEmptyOrNull(String str) {
        return str == null || str.trim().isEmpty();

    }
}

