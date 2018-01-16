package com.williamsilva.cursomc.cursomc.services;

import com.williamsilva.cursomc.cursomc.model.Categoria;
import com.williamsilva.cursomc.cursomc.repository.CategoriaRepository;
import com.williamsilva.cursomc.cursomc.services.exception.DataIntegrityException;
import com.williamsilva.cursomc.cursomc.services.exception.ObjetoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria find(Integer id) {
        Categoria categoria = categoriaRepository.findOne(id);

        if (categoria == null) {
            throw new ObjetoNotFoundException("Objeto não encontrado! Id: " + id +",  Tipo "+ Categoria.class.getName());
        }

        return categoria;
    }

    public Categoria insert(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria update(Categoria categoria) {
        find(categoria.getId());
        return categoriaRepository.save(categoria);
    }

    public void delete(Integer id) {
        find(id);
        try {
            categoriaRepository.delete(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
        }
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = new PageRequest(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return categoriaRepository.findAll(pageRequest);
    }
}
