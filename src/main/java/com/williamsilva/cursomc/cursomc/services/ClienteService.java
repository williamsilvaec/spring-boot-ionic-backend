package com.williamsilva.cursomc.cursomc.services;

import com.williamsilva.cursomc.cursomc.dto.ClienteDTO;
import com.williamsilva.cursomc.cursomc.model.Cliente;
import com.williamsilva.cursomc.cursomc.repository.ClienteRepository;
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

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = new PageRequest(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return clienteRepository.findAll(pageRequest);
    }

    public Cliente update(Cliente cliente) {
        Cliente novoCliente = find(cliente.getId());
        updateData(novoCliente, cliente);
        return clienteRepository.save(novoCliente);
    }

    public Cliente fromDTO(ClienteDTO clienteDTO) {
        return new Cliente(clienteDTO.getNome(), clienteDTO.getEmail(), null, null);
    }

    private void updateData(Cliente novoCliente, Cliente cliente) {
        novoCliente.setNome(cliente.getNome());
        novoCliente.setEmail(cliente.getEmail());
    }

    public void delete(Integer id) {
        find(id);
        try {
            clienteRepository.delete(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir porque há entidades relacionadas");
        }
    }
}
