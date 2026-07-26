package br.com.cauesobral.gerenciador_pedidos.model;

//5 - Crie uma classe Pedido com os seguintes atributos: id (Long, chave primária) data (LocalDate)
//A classe deve ter um construtor e os getters. Transforme a classe em entidade.

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Pedido {
    @Id
    private Long id;
    private LocalDate data;

    public Pedido() {
    }

    public Pedido(Long id, LocalDate data) {
        this.id = id;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }
}
