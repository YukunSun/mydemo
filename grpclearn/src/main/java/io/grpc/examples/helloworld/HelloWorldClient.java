package io.grpc.examples.helloworld;

import io.grpc.ManagedChannelBuilder;

/**
 * @author sunyk
 **/
public class HelloWorldClient {
//    GreeterGrpc.GreeterBlockingStub blockingStub =

    public static void main(String[] args) {
        String target = "localhost:50051";
        ManagedChannelBuilder<?> channel = ManagedChannelBuilder.forTarget(target);
    }
}