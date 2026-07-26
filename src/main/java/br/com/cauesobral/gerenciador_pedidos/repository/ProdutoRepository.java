package br.com.cauesobral.gerenciador_pedidos.repository;

import br.com.cauesobral.gerenciador_pedidos.model.Pedido;
import br.com.cauesobral.gerenciador_pedidos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    //Geralmente é na Reposiory que ficam as consultas Derived Queries

    //Consultas usando Derived Query
//    //Ex 1 (aula 4)
//    List<Produto> findByNome (String nome);
//    //Ex 2
//    List<Produto> findByCategoria (String nomeCategoria);
//    //Ex 3
//    List<Produto> findByPrecoGreaterThan(Double preco);
//    //Ex 4
//    List<Produto> findByPrecoLessThan(Double preco);
//    //Ex 5
//    List<Produto> findByNomeContaining(String nome);
//    //Ex 8
//    List<Produto> findByCategoriaOrderByPrecoAsc (String categoriaNome);
//    //Ex 9
//    List<Produto> findByCategoriaOrderByPrecoDesc (String categoriaNome);
//    //Ex 10
//    Long countByCategoriaNome (String categoriaNome);
//    //Ex 11
//    Long countByPrecoGreaterThan(double preco);
//    //Ex 12
//    List<Produto> findByPrecoLessThanOrNomeContaining(Double preco, String termo);
//    //Ex 14
//    List<Pedido> findByDataPedidoBefore(LocalDate dataDoPedido);
//    //Ex 16
//    List<Produto> findTop3ByPrecoDesc();
//    //Ex 17
//    List<Produto> findTop5ByCategoriaNomeOrderByPrecoAsc(String categoriaNome);

    //Ex 1 - Consultas JPQL
    @Query("SELECT p FROM Produto p WHERE p.preco > :preco")
    List<Produto> buscaPeloMaior(@Param("Preco") Double preco);

    //Ex 2
    @Query("SELECT p FROM Produto p ORDER BY p.preco ASC")
    List<Produto> buscaOrdenadaPrecoCrescente();

    //Ex 3
    @Query("SELECT p FROM produto P ORDER BY p.preco DESC")
    List<Produto> buscaPrecoProdutoDecrescente();

    //Ex 6
    @Query("SELECT AVG(p.preco) FROM Produto p")
    Double calcularMediaPrecoProdutos();

    //Ex 7
    @Query("SELECT MAX(p.preco) FROM Produto p WHERE p.categoria.nome = :categoria")
    Double buscarPrecoMaximoPorCategoria(@Param("categoria") String categoria);

    //Ex 8
    @Query("SELECT c.nome, COUNT(p) FROM Produto p JOIN p.categoria c GROUP BY c.nome")
    List<Object[]> contarProdutosPorCategoria();

    //Ex 9
    @Query("SELECT c.nome, COUNT(p) FROM Produto p JOIN p.categoria c " +
            "GROUP BY c.nome HAVING COUNT(p) > :quantidade")
    List<Object[]> categoriasComMaisDe(@Param("quantidade") long quantidade);

    //Ex 10
    @Query("SELECT p FROM Produto p WHERE (:nome IS NULL OR p.nome = :nome) AND " +
            "(:categoria IS NULL OR p.categoria.nome = :categoria)")
    List<Produto> buscarProdutosFiltrados(@Param("nome")
                                          String nome, @Param("categoria") String categoria);

    //Ex 11
    @Query(value = "SELECT * FROM produto ORDER BY preco DESC LIMIT 5",
            nativeQuery = true)
    List<Produto> buscarTop5ProdutosMaisCaros();
}