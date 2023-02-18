package com.example.livrariaapi.service.impl;

import com.example.livrariaapi.domain.entity.Autor;
import com.example.livrariaapi.domain.entity.Livro;
import com.example.livrariaapi.domain.entity.exception.BookNotFoundException;
import com.example.livrariaapi.domain.entity.exception.FieldInvalidException;
import com.example.livrariaapi.domain.entity.exception.UserNotFoundException;
import com.example.livrariaapi.dto.AutorDto;
import com.example.livrariaapi.dto.LivroDto;
import com.example.livrariaapi.repository.LivrosRepository;
import com.example.livrariaapi.service.Iservice;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LivroServiceImpl implements Iservice<LivroDto> {

    private final ModelMapper model;
    private final LivrosRepository banco;
    private final AutorServiceImpl autorService;

    @Override
    public List<LivroDto> obterTodos(LivroDto livroDto) {
        Livro livro = model.map(livroDto,Livro.class);
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Livro> example = Example.of(livro,matcher);
        List<Livro> listas = banco.findAll(example);
        if(listas.isEmpty()){
            throw  new FieldInvalidException();
        }
        List<LivroDto> resultado = new ArrayList<>();
        for (Livro l : listas){
            LivroDto dto = model.map(l,LivroDto.class);
            AutorDto autorDto = autorService.obterPorId(l.getAutor().getId());
            if (listas.isEmpty()){
                throw new UserNotFoundException();
            }
            dto.setAutor(autorDto);
            resultado.add(dto);
        }
        return resultado;
    }
    @Override
    public LivroDto obterPorId(Long id) {
        Optional<Livro> livro = banco.findById(id);
        if (banco.findById(id).isEmpty()){
            throw new BookNotFoundException();
        }
        if (livro.isEmpty()){
            throw new BookNotFoundException();
        }
        AutorDto autorDto = autorService.obterPorId(livro.get().getAutor().getId());
        LivroDto livroDto = model.map(livro.get(), LivroDto.class);
        livroDto.setAutor(autorDto);
        return livroDto;
    }
    @Override
    public LivroDto salvar(LivroDto livroDto) {
        Livro livro = model.map(livroDto,Livro.class);
        AutorDto autorDto = autorService.obterPorId(livroDto.getAutor().getId());
        livro.setAutor(model.map(autorDto, Autor.class));
        banco.save(livro);
        return model.map(livro,LivroDto.class);
    }
    @Override
    public LivroDto Atualizar(Long id, LivroDto livroDto) {
        Optional<Livro> livroOptional = banco.findById(id);
        if (livroOptional.isEmpty()) {
            throw new BookNotFoundException();
        }
        Livro livro = model.map(livroDto, Livro.class);
        livro.setId(id);
        livro.validarCampos();
        AutorDto autorDto = autorService.obterPorId(livro.getAutor().getId());
        Autor autor = model.map(autorDto, Autor.class);
        livro.setAutor(autor);
        Livro livroAtualizado = banco.save(livro);
        return model.map(livroAtualizado, LivroDto.class);
    }
    @Override
    public void Deletar(Long id) {
        Optional<Livro> livroid = banco.findById(id);
        banco.deleteById(id);
    }

    //ideias
    public LivroDto findByIdAndAutor(Long id, Long idAutor) {
        return null;
    }

    public LivroDto updateAutor(Long id, AutorDto autorDTO) {
        return null;
    }

    public boolean deleteAutor(Long id) {
        return false;
    }

    public LivroDto save(LivroDto livroDTO) {
         return null;
    }

    public List<LivroDto> findByAutor(Long idAutor) {
        return null;
    }
}

