package com.unifaj.restaurant.backend.repository;

import com.unifaj.restaurant.backend.model.ItensPedido;
import com.unifaj.restaurant.backend.model.ItensPedidoId;
import com.unifaj.restaurant.backend.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItensPedidoRepository extends JpaRepository<ItensPedido, ItensPedidoId> {
    List<ItensPedido> findByPedido(Pedido pedido);
}
