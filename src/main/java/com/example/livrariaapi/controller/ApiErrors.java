package com.example.livrariaapi.controller;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data

@NoArgsConstructor
public class ApiErrors {

    private LocalDateTime timestamp;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private String errorName;
    private String campo;
    private String message;


    public ApiErrors(String timestamp, String errorName, String campo, String message) {
        this.timestamp = LocalDateTime.parse(timestamp, formatter);
        this.errorName = errorName;
        this.campo = campo;
        this.message = message;
    }

    public ApiErrors(LocalDateTime timestamp, String errorName, String campo, String message) {
        this.timestamp = timestamp;
        this.errorName = errorName;
        this.campo = campo;
        this.message = message;
    }



    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getErrorName() {
        return errorName;
    }

    public void setErrorName(String errorName) {
        this.errorName = errorName;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public  static ApiErrors usuarioNaoEncontrado() {
        String formattedTimestamp = formatter.format(LocalDateTime.now());
        String errorName = "errorName";
        String campo = "id";
        String message = "Autor nao Encontrado";
        return new ApiErrors(formattedTimestamp, errorName, campo, message);
    }
    public  static ApiErrors livroNaoEncontrado() {
        String formattedTimestamp = formatter.format(LocalDateTime.now());
        String errorName = "errorBook";
        String campo = "id";
        String message = "Livro não Encontrado";
        return new ApiErrors(formattedTimestamp, errorName, campo, message);
    }

    public  static ApiErrors nomeEsobrenome() {
        String formattedTimestamp = formatter.format(LocalDateTime.now());
        String errorName = "errorName";
        String campo = "Nome ou Sobrenome";
        String message = "Nome ou Sobrenome Inválido";
        return new ApiErrors(formattedTimestamp, errorName, campo, message);
    }
    public  static ApiErrors campoInvalido() {
        String formattedTimestamp = formatter.format(LocalDateTime.now());
        String errorName = "errorEmpty";
        String campo = "Campo vazio";
        String message = "Informe um campo Válido";
        return new ApiErrors(formattedTimestamp, errorName, campo, message);
    }
    public  static ApiErrors tituloeDescricao() {
        String formattedTimestamp = formatter.format(LocalDateTime.now());
        String errorName = "errorEmpty";
        String campo = "Campo vazio";
        String message = "Titulo e Descrição Inválidos";
        return new ApiErrors(formattedTimestamp, errorName, campo, message);
    }

}
