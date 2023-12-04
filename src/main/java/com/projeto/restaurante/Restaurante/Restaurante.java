package com.projeto.restaurante.Restaurante;
import com.projeto.restaurante.Endereco.Endereco;
import com.projeto.restaurante.pratos.Prato;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "Restaurante")
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restauranteID;

    private String nome;

    private String email;

    private String senha;

    private Integer cnpj;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
}

