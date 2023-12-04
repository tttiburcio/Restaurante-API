package com.projeto.restaurante.pratos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PratoRepository extends JpaRepository<Prato, Long> {

    List<Prato> findByRestauranteRestauranteID(Long restauranteId);
}
