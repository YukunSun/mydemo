package io.grpc.examples.hello;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ListenableFuture;
import io.grpc.*;
import io.grpc.examples.helloworld.HelloReply;
import io.grpc.examples.helloworld.HelloRequest;
import io.grpc.examples.helloworld.HelloServiceGrpc;
import io.grpc.examples.helloworld.HelloServiceImpl;
import io.grpc.stub.StreamObserver;
import org.junit.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
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
    public void helloClientAsync() {
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
    public void helloStreamClientSSRpc() {
        ManagedChannel channel = ManagedChannelBuilder.forTarget(TARGET)
                .usePlaintext()
                .build();
        HelloServiceGrpc.HelloServiceBlockingStub blockingStub = HelloServiceGrpc.newBlockingStub(channel);

        for (int i = 0; i < 3; i++) {
            HelloRequest request = HelloRequest.newBuilder().setAge(i).setName("foo").setSex(false).addAllFav(Lists.newArrayList("Math", "English")).build();
            Iterator<HelloReply> response = blockingStub.sayHelloSSRpc(request);
            response.forEachRemaining(res -> {
                System.out.println("response:" + res);
            });
        }
        channel.shutdown();
    }

    @Test
    public void helloStreamClientCSRpc() throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forTarget(TARGET)
                .usePlaintext()
                .build();
        HelloServiceGrpc.HelloServiceStub asyncStub = HelloServiceGrpc.newStub(channel);

        final CountDownLatch finishLatch = new CountDownLatch(1);
        StreamObserver<HelloReply> replyStreamObserver = new StreamObserver<HelloReply>() {
            @Override
            public void onNext(HelloReply helloReply) {
                System.out.println(">> server response:" + helloReply);
            }

            @Override
            public void onError(Throwable throwable) {
                Status status = Status.fromThrowable(throwable);
                System.out.println(">> status" + status);
                finishLatch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println(">> client finished");
                finishLatch.countDown();
            }
        };

        StreamObserver<HelloRequest> requestObserver = asyncStub.sayHelloCSRpc(replyStreamObserver);
        for (int i = 0; i < 10; i++) {
            HelloRequest request = HelloRequest.newBuilder().setAge(i).setName("foo").setSex(false).addAllFav(Lists.newArrayList("Math", "English")).build();
            requestObserver.onNext(request);
        }
        requestObserver.onCompleted();

        finishLatch.await();
        channel.shutdown();
    }
}
