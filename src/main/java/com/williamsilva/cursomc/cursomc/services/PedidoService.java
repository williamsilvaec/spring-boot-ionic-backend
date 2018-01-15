package com.williamsilva.cursomc.cursomc.services;

import com.williamsilva.cursomc.cursomc.model.Pedido;
import com.williamsilva.cursomc.cursomc.repository.PedidoRepository;
import com.williamsilva.cursomc.cursomc.services.exception.ObjetoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido buscar(Integer codigo) {
        Pedido pedido = pedidoRepository.findOne(codigo);
        if (pedido == null) {
            throw new ObjetoNotFoundException("Objeto não encontrado! Id: " + codigo +",  " +
                    "Tipo " + Pedido.class.getName());
        }
        return pedido;
    }
}
