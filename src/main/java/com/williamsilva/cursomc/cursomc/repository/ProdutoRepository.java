package com.williamsilva.cursomc.cursomc.repository;

import com.williamsilva.cursomc.cursomc.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
