package com.williamsilva.cursomc.cursomc.resources;

import com.williamsilva.cursomc.cursomc.model.Pedido;
import com.williamsilva.cursomc.cursomc.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoResource {

    @Autowired private PedidoService pedidoService;

    @GetMapping("{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {
        Pedido pedido = pedidoService.buscar(id);
        return ResponseEntity.ok(pedido);
    }
}
