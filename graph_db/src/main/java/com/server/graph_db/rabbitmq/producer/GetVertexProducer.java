package com.server.graph_db.rabbitmq.producer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.server.graph_db.core.vertex.Vertex;

@Service
public class GetVertexProducer {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public GetVertexProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public Iterable<Vertex> send(Iterable<String> verticesIds, String serverId) {
        rabbitTemplate.setReplyTimeout(100000);
        ArrayList<Object> vertices = (ArrayList<Object>) rabbitTemplate.convertSendAndReceive(serverId, "GET_VERTEX",
        verticesIds);

        return convertToVertexType(vertices);
    }

    public Vertex send(String vertexId, String serverId) {
        List<String> verticesIds = new ArrayList<>();
        verticesIds.add(vertexId);
        ArrayList<Object> vertices = (ArrayList<Object>) rabbitTemplate.convertSendAndReceive(serverId, "GET_VERTEX",
                verticesIds);

        return convertToVertexType(vertices).get(0);
    }

    public List<Vertex> convertToVertexType(List<Object> vertices) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(vertices, new TypeReference<List<Vertex>>() {
        });

    }

}
