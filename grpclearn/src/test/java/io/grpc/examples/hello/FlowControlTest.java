package io.grpc.examples.hello;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.examples.helloworld.HelloReply;
import io.grpc.examples.helloworld.HelloRequest;
import io.grpc.examples.helloworld.HelloServiceGrpc;
import io.grpc.stub.ClientCallStreamObserver;
import io.grpc.stub.ClientResponseObserver;
import org.junit.Test;

import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author sunyk
 **/
public class FlowControlTest {
    /**
     * server: io.grpc.examples.hello.HelloWorldTest#helloServer()
     */
    @Test
    public void flowControlClient() throws InterruptedException {
        final CountDownLatch done = new CountDownLatch(1);

        ManagedChannel channel = ManagedChannelBuilder
                .forTarget(HelloWorldTest.TARGET)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceStub stub = HelloServiceGrpc.newStub(channel);
        ClientResponseObserver<HelloRequest, HelloReply> responseObserver = new ClientResponseObserver<HelloRequest, HelloReply>() {
            ClientCallStreamObserver<HelloRequest> clientCallStreamObserver;

            @Override
            public void beforeStart(ClientCallStreamObserver<HelloRequest> clientCallStreamObserver) {
                this.clientCallStreamObserver = clientCallStreamObserver;

                clientCallStreamObserver.disableAutoRequestWithInitial(1);
                clientCallStreamObserver.setOnReadyHandler(() -> {
                    Iterator<Integer> iterator = IntStream.range(0, 10).iterator();
                    while (clientCallStreamObserver.isReady()) {
                        if (iterator.hasNext()) {
                            HelloRequest request = HelloRequest.newBuilder()
                                    .setAge(iterator.next())
                                    .build();
                            clientCallStreamObserver.onNext(request);
                        } else {
                            clientCallStreamObserver.onCompleted();
                        }
                    }
                });
            }

            @Override
            public void onNext(HelloReply helloReply) {
                System.out.println(">>" + helloReply.toString());
                clientCallStreamObserver.request(1);
            }

            @Override
            public void onError(Throwable throwable) {
                done.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println(">> client all done...");
                done.countDown();
            }
        };

        stub.sayHelloBidRpc(responseObserver);

        done.await();

        channel.shutdown();
        channel.awaitTermination(10, TimeUnit.SECONDS);
    }
}
