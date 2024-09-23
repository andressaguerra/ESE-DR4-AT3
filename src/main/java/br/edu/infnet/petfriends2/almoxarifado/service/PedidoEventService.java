package br.edu.infnet.petfriends2.almoxarifado.service;

import br.edu.infnet.petfriends2.almoxarifado.config.RabbitMQConfig;
import br.edu.infnet.petfriends2.pedidos.model.PedidoDTO;
import br.edu.infnet.petfriends2.almoxarifado.model.PedidoEstoque;
import br.edu.infnet.petfriends2.almoxarifado.repository.PedidoEstoqueRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoEventService {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final PedidoEstoqueRepository pedidoEstoqueRepository;

    public PedidoEventService(PedidoEstoqueRepository pedidoEstoqueRepository) {
        this.pedidoEstoqueRepository = pedidoEstoqueRepository;
    }

    @RabbitListener(queues = RabbitMQConfig.FILA_PEDIDOS)
    public void receberEventoDePedido(String mensagem) {
        try {
            PedidoDTO pedidoDTO = objectMapper.readValue(mensagem, PedidoDTO.class);
            System.out.println("Evento recebido: " + pedidoDTO);

            Optional<PedidoEstoque> pedidoEstoqueOptional = pedidoEstoqueRepository.findById(Long.parseLong(pedidoDTO.getPedidoId()));

            if (pedidoEstoqueOptional.isPresent()) {
                PedidoEstoque pedidoEstoque = pedidoEstoqueOptional.get();

                if ("FECHADO".equals(pedidoDTO.getStatus())) {
                    pedidoEstoque.prepararPedido();
                    pedidoEstoqueRepository.save(pedidoEstoque);
                    System.out.println("Status do pedido atualizado para 'Em Preparação' no almoxarifado.");
                } else {
                    System.out.println("Status do pedido " + pedidoDTO.getPedidoId() + " não requer ação.");
                }

            } else {
                System.out.println("Pedido não encontrado: " + pedidoDTO.getPedidoId());
            }

        } catch (Exception e) {
            System.err.println("Erro ao processar a mensagem: " + e.getMessage());
        }
    }
}