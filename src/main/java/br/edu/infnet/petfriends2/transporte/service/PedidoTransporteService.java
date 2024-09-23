package br.edu.infnet.petfriends2.transporte.service;

import br.edu.infnet.petfriends2.pedidos.model.PedidoDTO;
import br.edu.infnet.petfriends2.transporte.config.RabbitMQTransporteConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PedidoTransporteService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = RabbitMQTransporteConfig.FILA_PEDIDOS_TRANSPORTE)
    public void receberEventoDePedido(String mensagem) {
        try {
            PedidoDTO pedidoDTO = objectMapper.readValue(mensagem, PedidoDTO.class);
            System.out.println("Evento recebido: " + pedidoDTO);

            if ("PRONTO_PARA_ENVIO".equals(pedidoDTO.getStatus())) {
                System.out.println("Pedido " + pedidoDTO.getPedidoId() + " está pronto para ser enviado.");
            } else {
                System.out.println("Pedido " + pedidoDTO.getPedidoId() + " não está pronto para envio.");
            }

        } catch (Exception e) {
            System.err.println("Erro ao processar a mensagem: " + e.getMessage());
        }
    }
}