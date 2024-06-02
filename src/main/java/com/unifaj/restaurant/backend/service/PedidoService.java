package com.unifaj.restaurant.backend.service;

import com.unifaj.restaurant.backend.dto.ItensPedidoDTO;
import com.unifaj.restaurant.backend.dto.PedidoDTO;
import com.unifaj.restaurant.backend.model.*;
import com.unifaj.restaurant.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ItensPedidoRepository itensPedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private MesaRepository mesaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Pedido> buscarPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido obterPedido(int id) throws Exception {
        return pedidoRepository.findById(id).
                orElseThrow(() -> new Exception("Pedido não existente"));
    }

    public Pedido criarPedido(PedidoDTO pedidoDTO) throws Exception {
        Mesa mesa = mesaRepository.findById(pedidoDTO.idMesa()).
                orElseThrow(() -> new Exception("Mesa não existente"));
        Cliente cliente = clienteRepository.findById(pedidoDTO.idCliente()).
                orElseThrow(() -> new Exception("Cliente não existente"));
        BigDecimal totalPedido = BigDecimal.valueOf(0);

        if (mesa.getStatusMesa()) {
            throw new Exception("Mesa ocupada");
        }

        Pedido pedido = new Pedido();
        mesa.setStatusMesa(true);
        mesaRepository.save(mesa);

        pedido.setDataPedido(pedidoDTO.dataPedido());
//        pedido.setStatusPago(pedidoDTO.statusPago());
        pedido.setStatusPago(false);
        pedido.setTotalPedido(BigDecimal.valueOf(0));
        pedido.setMesa(mesa);
        pedido.setCliente(cliente);

        Pedido pedidoSalvo = pedidoRepository.save(pedido);

        for (ItensPedidoDTO itemPedidoDTO : pedidoDTO.itens()) {
            Produto produto = produtoRepository.findById(itemPedidoDTO.idProduto()).
                    orElseThrow(() -> new Exception("Produto não existente"));
            BigDecimal totalItem = produto.getValorProduto().
                    multiply(BigDecimal.valueOf(itemPedidoDTO.quantidadePedido()));
            totalPedido = totalPedido.add(totalItem);

            ItensPedidoId itensPedidoId = new ItensPedidoId(pedidoSalvo.getIdPedido(),
                    produto.getIdProduto());

            ItensPedido itensPedido = new ItensPedido();
            itensPedido.setId(itensPedidoId);
            itensPedido.setPedido(pedidoSalvo);
            itensPedido.setQuantidadePedido(itemPedidoDTO.quantidadePedido());
            itensPedido.setValorTotal(totalItem);
            itensPedido.setProduto(produto);
            itensPedidoRepository.save(itensPedido);
        }

        pedidoRepository.save(pedidoSalvo);
        return pedidoSalvo;
    }

    public Pedido atualizarPedido(Pedido pedido, int id) throws Exception {
        Pedido pedidoToUpdate = pedidoRepository.findById(id).
                orElseThrow(() -> new Exception("Pedido não existente"));
        pedidoToUpdate.setIdPedido(id);
        pedidoToUpdate.setCliente(pedido.getCliente());
        pedidoToUpdate.setMesa(pedido.getMesa());
        pedidoToUpdate.setDataPedido(pedido.getDataPedido());
        return pedidoRepository.save(pedidoToUpdate);
    }

    public Pedido pagarPedido(int id) throws Exception {
        Pedido pedidoToUpdate = pedidoRepository.findById(id).
                orElseThrow(() -> new Exception("Pedido não existente"));

        Mesa mesa = pedidoToUpdate.getMesa();
        mesa.setStatusMesa(false);
        mesaRepository.save(mesa);

        return pedidoToUpdate;
    }

    public void deletarPedido(int id) {
        pedidoRepository.deleteById(id);
    }

}
