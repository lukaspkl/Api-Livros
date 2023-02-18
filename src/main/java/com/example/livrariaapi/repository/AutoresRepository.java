package com.example.livrariaapi.repository;

import com.example.livrariaapi.domain.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoresRepository extends JpaRepository<Autor,Long> {
}
