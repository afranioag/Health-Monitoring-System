package com.hms.ms_user.infraestructure.configs;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, Jackson2JsonMessageConverter messageConverter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }

    @Bean
    public FanoutExchange exampleExchange() {
        return new FanoutExchange("hms.user.exchange");
    }

    @Bean
    public Queue exampleQueue() {
        return new Queue("hms.basic-user.queue", true);
    }

    @Bean
    public Binding bindingExchange(Exchange exampleExchange, Queue exampleQueue) {
        return new Binding(exampleQueue.getName(), Binding.DestinationType.QUEUE, exampleExchange.getName(), "", null);
    }
}
