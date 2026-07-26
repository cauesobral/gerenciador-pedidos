package br.com.cauesobral.gerenciador_pedidos.repository;

import br.com.cauesobral.gerenciador_pedidos.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//O repositório no Spring, precisa ser public, porque ela vai ser acessado de fora, uma interface porque
//vai estabelecer um contrato, extrends JpaRepository porque ele vai implementar métodos da Jpa
//(Ex: save(), delete(), findById(), etc... e categoria é a classe do repo e Long é o tipo de Id, nesses casos
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
