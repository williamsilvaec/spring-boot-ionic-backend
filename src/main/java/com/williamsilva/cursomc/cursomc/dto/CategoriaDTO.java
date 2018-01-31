package com.williamsilva.cursomc.cursomc.dto;

import com.williamsilva.cursomc.cursomc.model.Categoria;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

public class CategoriaDTO implements Serializable {

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 10, message = "O tamanho deve ser entre 5 e 10 caracteres")
    private String nome;

    public CategoriaDTO() {}

    public CategoriaDTO(Categoria categoria) {
        id = categoria.getId();
        nome = categoria.getNome();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
