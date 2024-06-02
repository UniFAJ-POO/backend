package com.unifaj.restaurant.backend.controller;

import com.unifaj.restaurant.backend.model.Cliente;
import com.unifaj.restaurant.backend.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> buscarClientes() {
        return clienteService.buscarClientes();
    }

    @GetMapping("/{id}")
    public Cliente obterCliente(@PathVariable int id) throws Exception {
        return clienteService.obterCliente(id);
    }

    @PostMapping
    public Cliente criarCliente(@RequestBody Cliente cliente) {
        return clienteService.criarCliente(cliente);
    }

    @PutMapping("/{id}")
    public Cliente atualizarCliente(@RequestBody Cliente cliente, @PathVariable int id)
            throws Exception{
        return clienteService.atualizarCliente(cliente, id);
    }

    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable int id) {
        clienteService.deletarCliente(id);
    }
}
