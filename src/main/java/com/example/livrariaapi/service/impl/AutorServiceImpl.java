package com.example.livrariaapi.service.impl;

import com.example.livrariaapi.domain.entity.Autor;
import com.example.livrariaapi.domain.entity.exception.FieldInvalidException;
import com.example.livrariaapi.domain.entity.exception.NameAndSurnameException;
import com.example.livrariaapi.domain.entity.exception.UserNotFoundException;
import com.example.livrariaapi.dto.AutorDto;
import com.example.livrariaapi.repository.AutoresRepository;
import com.example.livrariaapi.service.Iservice;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class AutorServiceImpl implements Iservice<AutorDto> {

    private final ModelMapper model;
    private final AutoresRepository banco;

    @Override
    public List<AutorDto> obterTodos(AutorDto autorDto) {
        Autor autor = model.map(autorDto,Autor.class);
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Autor> example = Example.of(autor,matcher);
        List<Autor> lista = banco.findAll(example);

        if(lista.isEmpty()){
            throw  new FieldInvalidException();
        }
        return lista.stream().map(list -> model.map(list,AutorDto.class)).collect(Collectors.toList());
    }

    @Override
    public AutorDto obterPorId(Long id) {
        Optional<Autor> autor = banco.findById(id);
        if (autor.isEmpty()){
            throw new UserNotFoundException();
        }
        return model.map(autor.get(),AutorDto.class);
    }

    @Override
    public AutorDto salvar( @Valid AutorDto autorDto) {
        Autor autor = model.map(autorDto,Autor.class);
        if (autor.getNome().isEmpty() || autor.getSobrenome().isEmpty()){
            throw new NameAndSurnameException();
        }
         banco.save(autor);
        return model.map(autor,AutorDto.class);
    }
    @Override
    public AutorDto Atualizar(Long id, AutorDto autorDto) {
        Optional<Autor> autor = banco.findById(id);
        if (autor.isEmpty()){
            throw new UserNotFoundException();
        }
        Autor autoratualizado = model.map(autorDto, Autor.class);
        autoratualizado.setId(id);
        autoratualizado.setNome(autoratualizado.getNome());
        autoratualizado.setSobrenome(autoratualizado.getSobrenome());
        if (autoratualizado.getNome().isEmpty() || autoratualizado.getSobrenome().isEmpty()){
            throw new NameAndSurnameException();
        }
        banco.save(autoratualizado);
        return model.map(autoratualizado,AutorDto.class);
    }

    @Override
    public void Deletar(Long id) {
        Optional<Autor> autor = banco.findById(id);
        if (autor.isEmpty()){
            throw  new UserNotFoundException();
        }
        banco.deleteById(id);
    }

    // ideias de metodos
    public AutorDto findByLivroId(Long id) {
        return null;
    }

    public AutorDto findById(Long autorId) {
        return null;
    }
}
