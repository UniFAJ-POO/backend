package com.unifaj.restaurant.backend.service;

import com.unifaj.restaurant.backend.model.ItensPedido;
import com.unifaj.restaurant.backend.model.Pedido;
import com.unifaj.restaurant.backend.repository.ItensPedidoRepository;
import com.unifaj.restaurant.backend.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItensPedidoService {
    @Autowired
    private ItensPedidoRepository itensPedidoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<ItensPedido> buscarItens(int id) throws Exception {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new Exception("Pedido não existente"));

        return itensPedidoRepository.findByPedido(pedido);
    }
}
