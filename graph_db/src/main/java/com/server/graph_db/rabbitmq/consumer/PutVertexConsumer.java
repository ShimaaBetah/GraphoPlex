package com.server.graph_db.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.stereotype.Service;

import com.server.graph_db.core.exceptions.vertex.VertexAlreadyExistsException;
import com.server.graph_db.core.vertex.LocalVertexService;
import com.server.graph_db.core.vertex.Vertex;

@Service
public class PutVertexConsumer {

  
    @Autowired
    LocalVertexService vertexService;

     //listen to specific binding
    @RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "#{myQueryNameResolver.resolve()}"+".PUT_VERTEX"),
        exchange = @Exchange(value = "#{myServerProperties.serverId}", durable = "true", type = "topic"),
        key = "PUT_VERTEX"
    ))
    public void receiveMessage(Vertex vertex) {

        try {
            vertexService.addVertex(vertex);
        } catch (VertexAlreadyExistsException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
