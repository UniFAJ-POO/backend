package com.unifaj.restaurant.backend.repository;

import com.unifaj.restaurant.backend.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
