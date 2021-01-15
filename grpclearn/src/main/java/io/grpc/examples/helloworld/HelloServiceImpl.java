package io.grpc.examples.helloworld;

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
        System.out.println("req msg:" + request.toString());
        HelloReply reply = HelloReply.newBuilder().setMsg("response...age:" + request.getAge()).build();

        randomSleep();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<HelloRequest> sayHelloCSRpc(StreamObserver<HelloReply> responseObserver) {


        return super.sayHelloCSRpc(responseObserver);
    }

    @Override
    public StreamObserver<HelloRequest> sayHelloBidRpc(StreamObserver<HelloReply> responseObserver) {


        return super.sayHelloBidRpc(responseObserver);
    }

    void randomSleep() {
        try {
            Thread.sleep(1000 * ThreadLocalRandom.current().nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
