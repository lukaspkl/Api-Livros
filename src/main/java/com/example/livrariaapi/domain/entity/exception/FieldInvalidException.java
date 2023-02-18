package com.example.livrariaapi.domain.entity.exception;


import com.example.livrariaapi.controller.ApiErrors;

import java.util.List;

public class FieldInvalidException extends RuntimeException{

    public final List<ApiErrors> erros;

    public FieldInvalidException(){

        this.erros = List.of(ApiErrors.campoInvalido());
    }

    public List<ApiErrors> getErros(){
        return  erros;
    }

}
