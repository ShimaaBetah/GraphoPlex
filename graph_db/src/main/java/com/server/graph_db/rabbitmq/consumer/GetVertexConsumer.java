package com.server.graph_db.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.Queue;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.rabbit.annotation.Exchange;

import org.springframework.stereotype.Component;

import com.server.graph_db.core.vertex.LocalVertexService;
import com.server.graph_db.core.vertex.Vertex;

@Component
public class GetVertexConsumer {

    @Autowired
    LocalVertexService vertexService;

    @RabbitListener(bindings = @QueueBinding(value = @Queue(value = "#{myQueryNameResolver.resolve()}"
            + ".GET_VERTEX"), exchange = @Exchange(value = "#{myServerProperties.serverId}", durable = "true", type = "topic"), key = "GET_VERTEX"))

    public Iterable<Vertex> receiveMessage(Iterable<String> vertexIds) {
        return vertexService.getVerticesByIds(vertexIds);
    }
}