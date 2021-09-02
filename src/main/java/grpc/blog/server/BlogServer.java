package grpc.blog.server;

import grpc.blog.service.BlogServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;

import java.io.IOException;

public class BlogServer {

    public static void main(String[] args) {
        startServerAtPort(9090).run();
        startServerAtPort(9091).run();
        startServerAtPort(9092).run();

    }

    public static Runnable startServerAtPort(int port) {
        return () -> {
            System.out.println("Server started");

            Server server = ServerBuilder.forPort(9091)
                    .addService(new BlogServiceImpl())
                    .addService(ProtoReflectionService.newInstance())
                    .build();

            try {
                server.start();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Runtime.getRuntime().addShutdownHook(new Thread(
                    () -> {
                        System.out.println("Received Shutdown Request");
                        server.shutdown();
                        System.out.println("Successfully stopped the Greeting Server");
                    }
            ));

            try {
                server.awaitTermination();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }
}
