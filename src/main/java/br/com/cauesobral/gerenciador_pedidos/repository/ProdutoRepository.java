package br.com.cauesobral.gerenciador_pedidos.repository;

import br.com.cauesobral.gerenciador_pedidos.model.Pedido;
import br.com.cauesobral.gerenciador_pedidos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    //Geralmente é na Reposiory que ficam as consultas Derived Queries

    //Ex 1 (aula 4)
    List<Produto> findByNome (String nome);
    //Ex 2
    List<Produto> findByCategoria (String nomeCategoria);
    //Ex 3
    List<Produto> findByPrecoGreaterThan(Double preco);
    //Ex 4
    List<Produto> findByPrecoLessThan(Double preco);
    //Ex 5
    List<Produto> findByNomeContaining(String nome);
    //Ex 8
    List<Produto> findByCategoriaOrderByPrecoAsc (String categoriaNome);
    //Ex 9
    List<Produto> findByCategoriaOrderByPrecoDesc (String categoriaNome);
    //Ex 10
    Long countByCategoriaNome (String categoriaNome);
    //Ex 11
    Long countByPrecoGreaterThan(double preco);
    //Ex 12
    List<Produto> findByPrecoLessThanOrNomeContaining(Double preco, String termo);
    //Ex 14
    List<Pedido> findByDataPedidoBefore(LocalDate dataDoPedido);
    //Ex 16
    List<Produto> findTop3ByPrecoDesc();
    //Ex 17
    List<Produto> findTop5ByCategoriaNomeOrderByPrecoAsc(String categoriaNome);

}
