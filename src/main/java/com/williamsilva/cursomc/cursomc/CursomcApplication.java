package com.williamsilva.cursomc.cursomc;

import com.williamsilva.cursomc.cursomc.model.Categoria;
import com.williamsilva.cursomc.cursomc.model.Produto;
import com.williamsilva.cursomc.cursomc.repository.CategoriaRepository;
import com.williamsilva.cursomc.cursomc.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication

public class CursomcApplication implements CommandLineRunner{

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

    @Override
    public void run(String... strings) throws Exception {
        Categoria categoria1 = new Categoria("Informática");
        Categoria categoria2 = new Categoria("Escritório");

        Produto p1 = new Produto("Computador", 2000.00);
        Produto p2 = new Produto("Impressora", 800.00);
        Produto p3 = new Produto("Mouse", 80.00);

        categoria1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
        categoria2.getProdutos().addAll(Arrays.asList(p2));

        p1.getCategorias().addAll(Arrays.asList(categoria1));
        p2.getCategorias().addAll(Arrays.asList(categoria1, categoria2));
        p3.getCategorias().addAll(Arrays.asList(categoria1));

        categoriaRepository.save(Arrays.asList(categoria1, categoria2));
        produtoRepository.save(Arrays.asList(p1, p2, p3));
    }
}
