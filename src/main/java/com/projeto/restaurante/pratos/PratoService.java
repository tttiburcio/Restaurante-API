package com.projeto.restaurante.pratos;

import com.projeto.restaurante.Restaurante.Restaurante;
import com.projeto.restaurante.Restaurante.RestauranteService;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class PratoService {

    private final PratoRepository repository;

    private final RestauranteService restauranteService;

    public PratoService(PratoRepository repository, RestauranteService restauranteService) {
        this.repository = repository;
        this.restauranteService = restauranteService;
    }

    public void save(Prato prato) {
        Long restaurantId = Optional.ofNullable(prato.getRestaurante())
                .map(Restaurante::getRestauranteID)
                .orElseThrow(() -> new IllegalArgumentException("O id do restaurante é obrigatório."));

        Restaurante restaurante = restauranteService.findById(restaurantId)
                .orElseThrow(() -> new IllegalArgumentException("Restaurante não encontrado."));

        prato.setRestaurante(restaurante);

        repository.save(prato);
    }

    public void update(Prato prato, Long id) {
        repository.findById(id).ifPresent(it -> {
            prato.setPratoID(id);
            save(prato);
        });
    }

    public List<Prato> findAll(Long restauranteId) {
        return repository.findByRestauranteRestauranteID(restauranteId);
    }

    public void deletePrato(Long id) {
        repository.deleteById(id);
    }
}
