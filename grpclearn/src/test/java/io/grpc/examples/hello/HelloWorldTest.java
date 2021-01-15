package io.grpc.examples.hello;

import com.google.common.collect.Lists;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.examples.helloworld.HelloReply;
import io.grpc.examples.helloworld.HelloRequest;
import io.grpc.examples.helloworld.HelloServiceGrpc;
import io.grpc.examples.helloworld.HelloServiceImpl;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author sunyk
 **/
public class HelloWorldTest {
    @Test
    public void helloServer() throws InterruptedException, IOException {
        Server server = ServerBuilder.forPort(50051)
                .addService(new HelloServiceImpl())
                .build();

        server.start();
        server.awaitTermination(1, TimeUnit.MINUTES);
    }

    @Test
    public void helloClient() {
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
