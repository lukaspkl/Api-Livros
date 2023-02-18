package com.example.livrariaapi.controller;

import com.example.livrariaapi.domain.entity.exception.BookNotFoundException;
import com.example.livrariaapi.domain.entity.exception.FieldInvalidException;
import com.example.livrariaapi.domain.entity.exception.NameAndSurnameException;
import com.example.livrariaapi.domain.entity.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {


    private static ApiErrors api;


    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrors handlerNotFoundExpection (UserNotFoundException ex){
        return ApiErrors.usuarioNaoEncontrado();
    }
    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrors handlerNotFoundLivroException (BookNotFoundException ex){
        return ApiErrors.livroNaoEncontrado();
    }

    @ExceptionHandler(NameAndSurnameException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handlerNameAndSurname (NameAndSurnameException ex){
        return ApiErrors.nomeEsobrenome();
    }
    @ExceptionHandler(FieldInvalidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handlerFieldInvalidException (FieldInvalidException ex){
        return ApiErrors.campoInvalido();
    }
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handlerTitleAndDescriptionException (IllegalArgumentException ex){
        return ApiErrors.tituloeDescricao();
    }





}
