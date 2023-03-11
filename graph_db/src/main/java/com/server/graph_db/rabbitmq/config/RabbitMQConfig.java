package com.server.graph_db.rabbitmq.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    

    public static String [] exchanges = {"PUT_VERTEX"};
    public static String [] queues = {"queue0","queue1","queue2"};
     
    
    
    public Queue queue(int queueNumber) {
        //append queue number to word "queue" with format method 

        return new Queue(queues[queueNumber], false);
    }

    
    public TopicExchange exchange(String exchangeName) {
        return new TopicExchange(exchangeName);
    }
    


    
    


  
 


    

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }   


    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate; 
    }
     



    
}
