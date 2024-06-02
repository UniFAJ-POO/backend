package com.unifaj.restaurant.backend.service;

import com.unifaj.restaurant.backend.model.Cliente;
import com.unifaj.restaurant.backend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> buscarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente obterCliente(int id) throws Exception {
        return clienteRepository.findById(id).orElseThrow(() -> new Exception("Cliente não existente"));
    }

    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente atualizarCliente(Cliente cliente, int id) throws Exception {
        Cliente clienteToUpdate = clienteRepository.findById(id).orElseThrow(() -> new Exception("Cliente não existente"));
        clienteToUpdate.setIdCliente(id);
        clienteToUpdate.setCpfCliente(cliente.getCpfCliente());
        clienteToUpdate.setNomeCliente(cliente.getNomeCliente());

        return clienteRepository.save(clienteToUpdate);
    }

    public void deletarCliente(int id) {
        clienteRepository.deleteById(id);
    }
}
