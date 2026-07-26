package br.com.cauesobral.gerenciador_pedidos.model;

//4 - Crie uma classe Categoria com os atributos: id (Long, chave primária) nome (String)
//A classe deve ter um construtor e os getters. Transforme a classe em entidade.

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Categoria {
    @Id
    private Long id;
    private String nome;

}
