package com.williamsilva.cursomc.cursomc.resources;

import com.williamsilva.cursomc.cursomc.model.Cliente;
import com.williamsilva.cursomc.cursomc.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("{id}")
    public ResponseEntity<Cliente> find(@PathVariable Integer id) {
        Cliente cliente = clienteService.find(id);
        return ResponseEntity.ok(cliente);
    }
}
