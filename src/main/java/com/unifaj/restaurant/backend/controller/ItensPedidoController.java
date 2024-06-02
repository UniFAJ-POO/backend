package com.unifaj.restaurant.backend.controller;

import com.unifaj.restaurant.backend.model.ItensPedido;
import com.unifaj.restaurant.backend.service.ItensPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedido/itens")
public class ItensPedidoController {
    @Autowired
    private ItensPedidoService itensPedidoService;

    @GetMapping("/{id}")
    public List<ItensPedido> buscarItem(@PathVariable int id) throws Exception {
        return itensPedidoService.buscarItens(id);
    }
}
