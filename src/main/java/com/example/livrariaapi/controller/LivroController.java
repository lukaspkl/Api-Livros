package com.example.livrariaapi.controller;

import com.example.livrariaapi.dto.LivroDto;
import com.example.livrariaapi.service.impl.LivroServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/livros")
public class LivroController {

    private final LivroServiceImpl service;

    @PostMapping
    @ResponseStatus(CREATED)
    public LivroDto salvarlivro (@RequestBody @Valid LivroDto livroDto){
       return service.salvar(livroDto);
    }

    @GetMapping("{id}")
    public LivroDto obterLivroId (@PathVariable Long id){
        return service.obterPorId(id);
    }

    @GetMapping
    public ResponseEntity<List<LivroDto>> obtertodos (LivroDto livroDto){
        List<LivroDto> livroDtos = service.obterTodos(livroDto);
        return ResponseEntity.ok(livroDtos);
    }

    @PutMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public LivroDto atualizar (@PathVariable Long id,  @Valid @RequestBody LivroDto livroDto){
         return service.Atualizar(id, livroDto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void Deletar (@PathVariable  Long id ){
         service.Deletar(id);
    }
}
