package com.server.graph_db.rabbitmq.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.graph_db.vertex.Vertex;

@Service
public class PutVertexProducer {
    @Autowired
    private  RabbitTemplate rabbitTemplate;
    
    
    public PutVertexProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(Vertex vertex, String serverId) {
        rabbitTemplate.convertAndSend(serverId,"PUT_VERTEX" ,vertex);
    }  
}
