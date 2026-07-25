package br.com.cauesobral.gerenciador_pedidos.model;

//1 - Crie uma classe chamada Produto com os seguintes atributos: id (Long, chave primária) nome (String)
//preco (Double) Anote a classe com @Entity e mapeie o atributo id como chave primária com @Id.
//A classe deve ter um construtor e os getters.

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {
    @Id //Importar o do Jakarta persistence
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Não usar ponto e virgula depois de tags
    private Long id;
    private String nome;
    private Double preco;

    //Quem usa o JPA precisa usar dois construtores, um vazio para o JPA preencher e outro para o desenvolvedor
    //O JPA/Hibernate precisa sempre de um construtor vazio
    public Produto() {
    }

    public Produto(Long id, Double preco, String nome) {
        this.id = id;
        this.preco = preco;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
