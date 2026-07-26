package br.com.cauesobral.gerenciador_pedidos.model;

//4 - Crie uma classe Categoria com os atributos: id (Long, chave primária) nome (String)
//A classe deve ter um construtor e os getters. Transforme a classe em entidade.

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Categoria {
    @Id
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    List<Produto> produtos;
    //Isso aqui é mapear os relacionamentos das entidades, olha como a estrutura eh:
    //TAG(mappedBy (que é o nome da entidade no banco) = "categoria", cascade (tipo de mudança) =
    //CascadeType.ALL (porque eu quero que todas as mudanças sejam compartilhadas entre elas

    public Categoria() {
    }

    public Categoria(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
