package br.com.cauesobral.gerenciador_pedidos.repository;

import br.com.cauesobral.gerenciador_pedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    //Ex 6
    List<Pedido> findByDataEntregaIsNull();
    //Ex 7
    List<Pedido> findByDataEntregaIsNotNull();
    //Ex 13
    List<Pedido> findByDataPedidoAfter(LocalDate dataDoPedido);
    //Ex 15
    List<Pedido> findByDataPedidoBetween(LocalDate dataInicio, LocalDate dataFim);

}
