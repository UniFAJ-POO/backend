package com.unifaj.restaurant.backend.controller;

import com.unifaj.restaurant.backend.dto.PedidoDTO;
import com.unifaj.restaurant.backend.model.Pedido;
import com.unifaj.restaurant.backend.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> buscarPedidos() {
        return pedidoService.buscarPedidos();
    }

    @GetMapping("/{id}")
    public Pedido obterPedido(@PathVariable int id) throws Exception {
        return pedidoService.obterPedido(id);
    }

    @PostMapping("/")
    public Pedido criarPedido(@RequestBody PedidoDTO pedidoDTO) throws Exception {
        return pedidoService.criarPedido(pedidoDTO);
    }

    @PutMapping("/{id}")
    public Pedido atualizarPedido(@RequestBody Pedido pedido, @PathVariable int id) throws Exception {
        return pedidoService.atualizarPedido(pedido, id);
    }

    @PatchMapping("/{id}")
    public Pedido pagarPedido(@PathVariable int id) throws Exception {
        return pedidoService.pagarPedido(id);
    }

    @DeleteMapping("/{id}")
    public void deletarPedido(@PathVariable int id) {
        pedidoService.deletarPedido(id);
    }
}
