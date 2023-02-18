package com.example.livrariaapi.service;

import java.util.List;

public interface Iservice<DTO> {

    List<DTO> obterTodos(DTO dto);
    DTO obterPorId (Long id);
    DTO salvar (DTO dto);
    DTO Atualizar (Long id, DTO dto);
    void Deletar (Long id);
}
