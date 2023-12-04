package com.projeto.restaurante.Endereco;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public List<Endereco> getAllEnderecos() {
        return enderecoService.getAllEnderecos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> getEnderecoById(@PathVariable Long id) {
        Optional<Endereco> endereco = enderecoService.getEnderecoById(id);
        return endereco.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Endereco> saveEndereco(@RequestBody Endereco endereco) {
        Endereco savedEndereco = enderecoService.saveEndereco(endereco);
        return ResponseEntity.ok(savedEndereco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> updateEndereco(@PathVariable Long id, @RequestBody Endereco endereco) {
        if (!enderecoService.getEnderecoById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        endereco.setEnderecoID(id);
        Endereco updatedEndereco = enderecoService.saveEndereco(endereco);
        return ResponseEntity.ok(updatedEndereco);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEndereco(@PathVariable Long id) {
        if (!enderecoService.getEnderecoById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        enderecoService.deleteEndereco(id);
        return ResponseEntity.ok().build();
    }
}
