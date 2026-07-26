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
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
//Consultas usando Derived Query
    //    //Ex 6
//    List<Pedido> findByDataEntregaIsNull();
//    //Ex 7
//    List<Pedido> findByDataEntregaIsNotNull();
//    //Ex 13
//    List<Pedido> findByDataPedidoAfter(LocalDate dataDoPedido);
//    //Ex 15
//    List<Pedido> findByDataPedidoBetween(LocalDate dataInicio, LocalDate dataFim);

    // Ex 4
    @Query("SELECT p FROM Produto p WHERE p.nome LIKE :letra%")
    List<Produto> buscarProdutosPorLetraInicial(@Param("letra") String letra);

    //Ex 5
    @Query("SELECT p FROM Pedido p WHERE p.dataPedido BETWEEN :inicio AND :fim")
    List<Pedido> buscarPedidosPorPeriodo(@Param("inicio") LocalDate inicio, @Param("fim") LocalDate fim);
}
