package com.projeto.restaurante.Restaurante;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestauranteService {

    private final RestauranteRepository repository;

    public RestauranteService(RestauranteRepository repository) {
        this.repository = repository;
    }

    public void save(Restaurante restaurante) {
        repository.save(restaurante);
    }

    public Optional<Restaurante> findById(Long id) {
        return repository.findById(id);
    }

    public Optional<Restaurante> realizarLogin(RestauranteLogin restauranteLogin) {
        Optional<Restaurante> optionalRestaurante = repository.findByEmail(restauranteLogin.getEmail());

        if (optionalRestaurante.isEmpty()) {
            return Optional.empty();
        }

        Restaurante restaurante = optionalRestaurante.get();

        if (restaurante.getSenha().equals(restauranteLogin.getSenha())) {
            return optionalRestaurante;
        } else {
            return Optional.empty();
        }
    }
}
