package br.edu.infnet.petfriends2.almoxarifado.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String FILA_PEDIDOS = "fila_pedidos";
    public static final String EXCHANGE_PEDIDOS = "exchange_pedidos";
    public static final String ROTA_PEDIDOS = "rota_pedidos";

    @Bean
    public Queue filaPedidos() {
        return new Queue(FILA_PEDIDOS, true);
    }

    @Bean
    public TopicExchange exchangePedidos() {
        return new TopicExchange(EXCHANGE_PEDIDOS);
    }

    @Bean
    public Binding bindingPedidos(Queue filaPedidos, TopicExchange exchangePedidos) {
        return BindingBuilder.bind(filaPedidos).to(exchangePedidos).with(ROTA_PEDIDOS);
    }
}