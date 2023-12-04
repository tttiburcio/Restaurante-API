package com.projeto.restaurante.Restaurante;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    private final RestauranteService service;

    public RestauranteController(RestauranteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Restaurante restaurante) {
        service.save(restaurante);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/login")
    public ResponseEntity<Restaurante> login(@RequestBody RestauranteLogin restaurante) {
        Optional<Restaurante> optionalRestaurante = service.realizarLogin(restaurante);
        if (optionalRestaurante.isPresent()) {
            return ResponseEntity.ok(optionalRestaurante.get());
        } else {
            return ResponseEntity.status(401).build();
        }
    }
}
