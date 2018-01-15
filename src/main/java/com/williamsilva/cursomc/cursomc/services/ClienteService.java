package com.williamsilva.cursomc.cursomc.services;

import com.williamsilva.cursomc.cursomc.model.Cliente;
import com.williamsilva.cursomc.cursomc.repository.ClienteRepository;
import com.williamsilva.cursomc.cursomc.services.exception.ObjetoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente find(Integer id) {
        Cliente cliente = clienteRepository.findOne(id);
        if (cliente == null) {
            throw new ObjetoNotFoundException("Objeto não encontrado! Id: " + id +",  Tipo " + Cliente.class.getName());
        }

        return cliente;
    }
}
