package io.grpc.examples.helloworld;

import com.google.common.collect.Lists;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author sunyk
 **/
public class HelloWorldClient {
    public static void main(String[] args) {
        String target = "localhost:50051";
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
                .usePlaintext()
                .build();
        HelloServiceGrpc.HelloServiceBlockingStub blockingStub = HelloServiceGrpc.newBlockingStub(channel);

        HelloRequest request = HelloRequest.newBuilder().setAge(13).setName("foo").setSex(false).addAllFav(Lists.newArrayList("Math", "English")).build();
        HelloReply response = blockingStub.sayHello(request);
        System.out.println("response:" + response);

        channel.shutdown();
    }
}