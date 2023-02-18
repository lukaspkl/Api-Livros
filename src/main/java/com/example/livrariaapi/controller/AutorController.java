package com.example.livrariaapi.controller;

import com.example.livrariaapi.dto.AutorDto;
import com.example.livrariaapi.service.impl.AutorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/autores")
public class AutorController {


    private final AutorServiceImpl service;
    @PostMapping
    @ResponseStatus(CREATED)
    public AutorDto salvar (@RequestBody @Valid AutorDto autorDto){
       return autorDto = service.salvar(autorDto);
    }

    @GetMapping("{id}")
    public AutorDto obterPorId (@PathVariable Long id){
        return service.obterPorId(id);

    }

    @GetMapping
    public ResponseEntity<List<AutorDto>> obtertodos (AutorDto autorDto){
         List<AutorDto> autorDtos = service.obterTodos(autorDto);

         return ResponseEntity.ok(autorDtos);
    }

    @PutMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public AutorDto atualizar (@PathVariable Long id,@RequestBody @Valid AutorDto autorDto){
       return service.Atualizar(id, autorDto);

    }

    @DeleteMapping("{id}")
    public void deletar (@PathVariable Long id){
        service.Deletar(id);
    }

}
