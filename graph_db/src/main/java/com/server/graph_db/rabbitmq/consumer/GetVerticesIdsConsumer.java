package com.server.graph_db.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.Queue;

import java.util.LinkedList;

import org.springframework.amqp.rabbit.annotation.Exchange;

import com.server.graph_db.vertex.VertexService;


@Component
public class GetVerticesIdsConsumer {
    @Autowired
    VertexService vertexService;


    @RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "#{myQueryNameResolver.resolve()}"+".GET_VERTICES_IDS"),
        exchange = @Exchange(value = "#{myServerProperties.serverId}", durable = "true", type = "topic"),
        key = "GET_VERTICES_IDS"
    ))
    public Iterable<Integer> receiveMessage(String x) {
        System.out.println("Received Messageeeeeeeeeeeeeeeeeee") ;
        return vertexService.getAllVerticesIds();
    }
}
