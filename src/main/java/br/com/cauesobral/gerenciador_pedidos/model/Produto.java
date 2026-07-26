package br.com.cauesobral.gerenciador_pedidos.model;

import jakarta.persistence.*;

@Entity
public class Produto {
    @Id //Importar o do Jakarta persistence
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Não usar ponto e virgula depois de tags
    private Long id;
    @Column(unique = true, nullable = false) //nullable para definir se será nulo ou nao, unique para definir se sera
    //unico
    private String nome;
    @Column(name = "valor") //name para definir o nome da coluna
    private Double preco;

    @ManyToOne //Many to One não precisa preencher os campos mappedBy nem CascadeType
    @JoinColumn(name = "categoria_id")
    private Categoria caregoria; //categoria que o produto faz parte


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
