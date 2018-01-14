package com.williamsilva.cursomc.cursomc.repository;

import com.williamsilva.cursomc.cursomc.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
