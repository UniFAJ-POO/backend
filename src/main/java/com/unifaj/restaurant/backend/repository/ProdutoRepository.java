package com.unifaj.restaurant.backend.repository;

import com.unifaj.restaurant.backend.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
