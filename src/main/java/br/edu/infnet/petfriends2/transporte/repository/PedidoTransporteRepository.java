package br.edu.infnet.petfriends2.transporte.repository;

import br.edu.infnet.petfriends2.transporte.model.PedidoTransporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoTransporteRepository extends JpaRepository<PedidoTransporte, Long> {
}