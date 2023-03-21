package com.server.graph_db.rabbitmq.producer;

import java.util.LinkedList;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.graph_db.vertex.Vertex;

@Service
public class GetVerticesIdsProducer {
    @Autowired
    RabbitTemplate rabbitTemplate;
    
    public GetVerticesIdsProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public Iterable<Integer> send(String serverId) {
        return (Iterable<Integer>) rabbitTemplate.convertSendAndReceive(serverId, "GET_VERTICES_IDS","");
    }

}
