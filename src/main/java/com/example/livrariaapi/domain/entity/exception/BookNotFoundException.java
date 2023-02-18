package com.example.livrariaapi.domain.entity.exception;

import com.example.livrariaapi.controller.ApiErrors;
import lombok.RequiredArgsConstructor;

import java.util.List;


public class BookNotFoundException extends RuntimeException {

    private final List<ApiErrors> erros;

    public BookNotFoundException() {
        super();
        this.erros = List.of(ApiErrors.livroNaoEncontrado());

    }


    public List<ApiErrors> getErros(){
        return erros;
    }
}
