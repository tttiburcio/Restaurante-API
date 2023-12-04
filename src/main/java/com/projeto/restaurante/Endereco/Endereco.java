package com.projeto.restaurante.Endereco;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enderecoID;

    private Integer cep;

    private String logradouro;

    private String bairro;

    private Short numero;

    private String complemento;

    private String cidade;

    private String uf;
}
