package com.williamsilva.cursomc.cursomc.services;

import com.williamsilva.cursomc.cursomc.model.Categoria;
import com.williamsilva.cursomc.cursomc.repository.CategoriaRepository;
import com.williamsilva.cursomc.cursomc.services.exception.ObjetoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria buscar(Integer id) {
        Categoria categoria = categoriaRepository.findOne(id);

        if (categoria == null) {
            throw new ObjetoNotFoundException("Objeto não encontrado! Id: " + id +",  Tipo "+ Categoria.class.getName());
        }

        return categoria;
    }

    public Categoria insert(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
}
