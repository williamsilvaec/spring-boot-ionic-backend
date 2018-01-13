package com.williamsilva.cursomc.cursomc.services;

import com.williamsilva.cursomc.cursomc.model.Categoria;
import com.williamsilva.cursomc.cursomc.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria buscar(Integer id) {
        return categoriaRepository.findOne(id);
    }
}
