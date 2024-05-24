package com.unifaj.restaurant.backend.repository;

import com.unifaj.restaurant.backend.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
