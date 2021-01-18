package io.grpc.examples.helloworld;

import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author sunyk
 **/
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        System.out.println("req msg:" + request.toString());

        randomSleep();

        HelloReply reply = HelloReply.newBuilder().setMsg("response...age:" + request.getAge()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void sayHelloSSRpc(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        for (int i = 0; i < 5; i++) {
            HelloReply reply = HelloReply.newBuilder().setMsg("response...age:" + request.getAge()).build();

            randomSleepShort();

            responseObserver.onNext(reply);
        }
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<HelloRequest> sayHelloCSRpc(StreamObserver<HelloReply> responseObserver) {
        randomSleep();

        HelloReply reply = HelloReply.newBuilder().setMsg("<< response from server...").build();

        return new StreamObserver<HelloRequest>() {
            @Override
            public void onNext(HelloRequest helloRequest) {
                System.out.println(helloRequest);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("<< server done...");

                responseObserver.onNext(reply);
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<HelloRequest> sayHelloBidRpc(StreamObserver<HelloReply> responseObserver) {
        ServerCallStreamObserver<HelloReply> serverCallStreamObserver = (ServerCallStreamObserver<HelloReply>) responseObserver;
        //todo
        serverCallStreamObserver.disableAutoRequest();

        class OnReadyHandler implements Runnable {
            //todo: guard against race
            private boolean wasReady = false;

            @Override
            public void run() {
                if (serverCallStreamObserver.isReady() && !wasReady) {
                    wasReady = true;
                    System.out.println(">> server ready...");
                    serverCallStreamObserver.request(1);
                }
            }
        }
        final OnReadyHandler onReadyHandler = new OnReadyHandler();
        serverCallStreamObserver.setOnReadyHandler(onReadyHandler);

        return new StreamObserver<HelloRequest>() {
            @Override
            public void onNext(HelloRequest helloRequest) {
                randomSleep();

                HelloReply reply = HelloReply.newBuilder().setMsg("response..." + helloRequest.getAge()).build();
                serverCallStreamObserver.onNext(reply);
                if (serverCallStreamObserver.isReady()) {
                    serverCallStreamObserver.request(1);
                } else {
                    onReadyHandler.wasReady = false;
                }
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
                responseObserver.onCompleted();
            }

            @Override
            public void onCompleted() {
                System.out.println("Server completed...");
                responseObserver.onCompleted();
            }
        };
    }

    void randomSleep() {
        try {
            Thread.sleep(1000 * ThreadLocalRandom.current().nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void randomSleepShort() {
        try {
            Thread.sleep(1000 * ThreadLocalRandom.current().nextInt(3));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
