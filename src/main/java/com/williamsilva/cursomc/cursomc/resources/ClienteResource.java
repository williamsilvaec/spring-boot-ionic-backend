package com.williamsilva.cursomc.cursomc.resources;

import com.williamsilva.cursomc.cursomc.dto.ClienteDTO;
import com.williamsilva.cursomc.cursomc.model.Cliente;
import com.williamsilva.cursomc.cursomc.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> findAll() {
        List<Cliente> clientes = clienteService.findAll();
        List<ClienteDTO> clienteDTOS = clientes.stream().map(ClienteDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(clienteDTOS);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody ClienteDTO clienteDTO, @PathVariable Integer id) {
        Cliente cliente = clienteService.fromDTO(clienteDTO);
        cliente.setId(id);
        cliente = clienteService.update(cliente);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/page")
    public ResponseEntity<Page<ClienteDTO>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {

        Page<Cliente> clientePage = clienteService.findPage(page, linesPerPage, orderBy, direction);
        Page<ClienteDTO> clienteDTOPage = clientePage.map(ClienteDTO::new);
        return ResponseEntity.ok(clienteDTOPage);
    }
}