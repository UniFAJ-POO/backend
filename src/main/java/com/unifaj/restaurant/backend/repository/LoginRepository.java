package com.unifaj.restaurant.backend.repository;

import com.unifaj.restaurant.backend.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Integer> {
}
