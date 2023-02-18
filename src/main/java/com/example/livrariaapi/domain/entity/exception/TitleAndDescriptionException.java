package com.example.livrariaapi.domain.entity.exception;

import com.example.livrariaapi.controller.ApiErrors;

import java.util.List;

public class TitleAndDescriptionException extends RuntimeException{

    public final List<ApiErrors> erros;

    public TitleAndDescriptionException (){
        this.erros = List.of(ApiErrors.tituloeDescricao());
    }
}
