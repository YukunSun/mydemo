package io.grpc.examples.helloworld;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author sunyk
 **/
public class HelloWorldServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(50051)
                .addService(new HelloServiceImpl())
                .build();

        server.start();
        server.awaitTermination(1, TimeUnit.MINUTES);
    }
}
