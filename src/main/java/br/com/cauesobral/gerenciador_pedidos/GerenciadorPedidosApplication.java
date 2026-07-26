package br.com.cauesobral.gerenciador_pedidos;

import br.com.cauesobral.gerenciador_pedidos.model.Categoria;
import br.com.cauesobral.gerenciador_pedidos.model.Pedido;
import br.com.cauesobral.gerenciador_pedidos.model.Produto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class GerenciadorPedidosApplication  {
	public static void main(String[] args) {
		SpringApplication.run(GerenciadorPedidosApplication.class, args);
	}
}
