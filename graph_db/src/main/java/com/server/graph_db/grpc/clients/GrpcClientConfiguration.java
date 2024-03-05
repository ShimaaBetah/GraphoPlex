package com.server.graph_db.grpc.clients;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcClientConfiguration {

    @Value("${grpc.servers.ports}")
    private  String[] ports;

    @Value("${grpc.servers.hosts}")
    private  String[] hosts;

    @Bean
    public ManagedChannel grpcManagedChannel() {
        return ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
    }

  @Bean(name = "grpcChannels")
  public Map<String, ManagedChannel> grpcChannels() {
    Map<String, ManagedChannel> channels = new HashMap<>();

    for (int i = 0;i<ports.length;i++) {
      ManagedChannel channel = ManagedChannelBuilder.forAddress(hosts[i], Integer.parseInt(ports[i])).maxInboundMessageSize(Integer.MAX_VALUE).usePlaintext().build();
      channels.put(Integer.toString(i), channel);
    }
    return channels;
  }
}
