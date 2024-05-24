package com.unifaj.restaurant.backend.repository;

import com.unifaj.restaurant.backend.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
