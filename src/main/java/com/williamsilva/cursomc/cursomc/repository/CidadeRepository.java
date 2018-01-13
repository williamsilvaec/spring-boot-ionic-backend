package com.williamsilva.cursomc.cursomc.repository;

import com.williamsilva.cursomc.cursomc.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
}
