package com.example.livrariaapi.domain.entity.exception;

import com.example.livrariaapi.controller.ApiErrors;

import java.util.List;

public class UserNotFoundException extends RuntimeException{

    private final List<ApiErrors> erros;

    public UserNotFoundException() {
        super();
        this.erros = List.of(ApiErrors.usuarioNaoEncontrado());

    }


    public List<ApiErrors> getErros(){
        return erros;
    }
}
