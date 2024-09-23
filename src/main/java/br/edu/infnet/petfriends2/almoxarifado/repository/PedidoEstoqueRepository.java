package br.edu.infnet.petfriends2.almoxarifado.repository;

import br.edu.infnet.petfriends2.almoxarifado.model.PedidoEstoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoEstoqueRepository extends JpaRepository<PedidoEstoque, Long> {
}