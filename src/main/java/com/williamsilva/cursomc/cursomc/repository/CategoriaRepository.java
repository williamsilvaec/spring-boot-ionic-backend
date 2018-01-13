package com.williamsilva.cursomc.cursomc.repository;

import com.williamsilva.cursomc.cursomc.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {
}
