package io.grpc.examples.hello;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ListenableFuture;
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
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author sunyk
 **/
public class HelloWorldTest {
    public static final String TARGET = "localhost:50051";

    @Test
    public void helloServer() throws InterruptedException, IOException {
        Server server = ServerBuilder.forPort(50051)
                .addService(new HelloServiceImpl())
                .build();

        server.start();
//        server.awaitTermination(5, TimeUnit.MINUTES);
        server.awaitTermination();
    }

    @Test
    public void helloClient() {
        ManagedChannel channel = ManagedChannelBuilder.forTarget(TARGET)
                .usePlaintext()
                .build();
        HelloServiceGrpc.HelloServiceBlockingStub blockingStub = HelloServiceGrpc.newBlockingStub(channel);

        for (int i = 0; i < 10; i++) {
            HelloRequest request = HelloRequest.newBuilder().setAge(i).setName("foo").setSex(false).addAllFav(Lists.newArrayList("Math", "English")).build();
            HelloReply response = blockingStub.sayHello(request);
            System.out.println("response:" + response);
        }

        channel.shutdown();
    }

    @Test
    public void helloClient2() {
        ManagedChannel channel = ManagedChannelBuilder.forTarget(TARGET)
                .usePlaintext()
                .build();
        HelloServiceGrpc.HelloServiceFutureStub futureStub = HelloServiceGrpc.newFutureStub(channel);

        for (int i = 0; i < 10; i++) {
            HelloRequest request = HelloRequest.newBuilder().setAge(i).setName("foo").setSex(false).addAllFav(Lists.newArrayList("Math", "English")).build();
            ListenableFuture<HelloReply> reply = futureStub.sayHello(request);

            try {
                System.out.println("response:" + reply.get(2, TimeUnit.SECONDS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }

        channel.shutdown();
    }

    @Test
    public void helloStreamClient() {

    }
}
