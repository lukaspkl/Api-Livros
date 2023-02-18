package com.example.livrariaapi.controller;

import com.example.livrariaapi.dto.AutorDto;
import com.example.livrariaapi.dto.LivroDto;
import com.example.livrariaapi.service.impl.AutorServiceImpl;
import com.example.livrariaapi.service.impl.LivroServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/autores/{idAutor}/livros")
public class LivroAutorController {

    private final LivroServiceImpl livroService;
    private final AutorServiceImpl autorService;

// essa parte foi feita por i.a pra eu estudar, ainda nao sei chegar nesse ponto do API

    @GetMapping
    public ResponseEntity<List<LivroDto>> getLivrosByAutor(@PathVariable Long idAutor) {
        AutorDto autorDTO = autorService.findById(idAutor);
        if (autorDTO == null) {
            return ResponseEntity.notFound().build();
        }
        List<LivroDto> livrosDTO = livroService.findByAutor(idAutor);
        return ResponseEntity.ok(livrosDTO);
    }

    @PostMapping
    public ResponseEntity<LivroDto> createLivro(@PathVariable Long idAutor, @RequestBody LivroDto livroDTO) {
        AutorDto autorDTO = autorService.findById(idAutor);
        if (autorDTO == null) {
            return ResponseEntity.notFound().build();
        }
        livroDTO.setAutor(autorDTO);
        LivroDto createdLivroDTO = livroService.save(livroDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLivroDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDto> getLivroById(@PathVariable Long id, @PathVariable Long idAutor) {
        LivroDto livroDTO = livroService.findByIdAndAutor(id, idAutor);
        if (livroDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(livroDTO);
    }

    @GetMapping("/livros/{id}/autor")
    public ResponseEntity<AutorDto> getAutorByLivro(@PathVariable Long id) {
        AutorDto autorDTO = autorService.findByLivroId(id);
        if (autorDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(autorDTO);
    }

    @PutMapping("/livros/{id}/autor/{autorId}")
    public ResponseEntity<LivroDto> updateLivroAutor(@PathVariable Long id, @PathVariable Long autorId) {
        AutorDto autorDTO = autorService.findById(autorId);
        if (autorDTO == null) {
            return ResponseEntity.notFound().build();
        }
        LivroDto livroDTO = livroService.updateAutor(id, autorDTO);
        if (livroDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(livroDTO);
    }

    @DeleteMapping("/livros/{id}/autor")
    public ResponseEntity<Void> deleteLivroAutor(@PathVariable Long id) {
        boolean deleted = livroService.deleteAutor(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
