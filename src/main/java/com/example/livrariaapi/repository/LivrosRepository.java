package com.example.livrariaapi.repository;

import com.example.livrariaapi.domain.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivrosRepository extends JpaRepository<Livro,Long> {
}
