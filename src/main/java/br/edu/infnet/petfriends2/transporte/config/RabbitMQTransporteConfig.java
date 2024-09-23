package br.edu.infnet.petfriends2.transporte.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQTransporteConfig {

    public static final String FILA_PEDIDOS_TRANSPORTE = "fila_pedidos_transporte";
    public static final String EXCHANGE_PEDIDOS_TRANSPORTE = "exchange_pedidos_transporte";
    public static final String ROTA_PEDIDOS_TRANSPORTE = "rota_pedidos_transporte";

    @Bean
    public Queue filaPedidosTransporte() {
        return new Queue(FILA_PEDIDOS_TRANSPORTE, true);
    }

    @Bean
    public TopicExchange exchangePedidosTransporte() {
        return new TopicExchange(EXCHANGE_PEDIDOS_TRANSPORTE);
    }

    @Bean
    public Binding bindingPedidosTransporte(Queue filaPedidosTransporte, TopicExchange exchangePedidosTransporte) {
        return BindingBuilder.bind(filaPedidosTransporte).to(exchangePedidosTransporte).with(ROTA_PEDIDOS_TRANSPORTE);
    }
}