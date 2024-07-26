package com.partheeban.component.grpc;


import com.partheeban.grpc.GreetRequest;
import com.partheeban.grpc.GreetResponse;
import com.partheeban.grpc.GreetServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GreetingService  extends GreetServiceGrpc.GreetServiceImplBase {

    @Override
    public void greet(GreetRequest request, StreamObserver<GreetResponse> responseObserver) {
        String name = request.getName();
        String greeting = "Hello " + name;
        GreetResponse response = GreetResponse.newBuilder()
                .setGreeting(greeting)
                .build();

        // Send the response
        responseObserver.onNext(response);

        // Complete the RPC call
        responseObserver.onCompleted();



    }
}
