package io.grpc.examples.helloworld;

import io.grpc.stub.StreamObserver;

/**
 * @author sunyk
 **/
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        System.out.println("req msg:" + request.toString());

        HelloReply reply = HelloReply.newBuilder().setMsg("Trump over...").build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
