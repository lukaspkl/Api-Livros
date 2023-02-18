package com.example.livrariaapi.domain.entity.exception;


import com.example.livrariaapi.controller.ApiErrors;

import java.util.List;

public class NameAndSurnameException extends RuntimeException{

    private final List<ApiErrors> erros;

    public NameAndSurnameException(){
        super();

        this.erros = List.of(ApiErrors.nomeEsobrenome());
    }

    public List<ApiErrors> getErros(){
        return erros;
    }
}
