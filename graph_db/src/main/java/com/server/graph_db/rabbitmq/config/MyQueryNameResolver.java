package com.server.graph_db.rabbitmq.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyQueryNameResolver {
    
    @Value("#{@myServerProperties.serverId}")
    private String serverId;

    public String resolve(){
        return "queue"+serverId;
    }
}
