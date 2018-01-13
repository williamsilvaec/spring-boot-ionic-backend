package com.williamsilva.cursomc.cursomc.resources;

import com.williamsilva.cursomc.cursomc.model.Categoria;
import com.williamsilva.cursomc.cursomc.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("{id}")
    public ResponseEntity<?> listar(@PathVariable Integer id) {
        Categoria categoria = categoriaService.buscar(id);
        return ResponseEntity.ok(categoria);
    }
}
