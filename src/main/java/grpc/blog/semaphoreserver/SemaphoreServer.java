package grpc.blog.semaphoreserver;

import grpc.blog.service.SemaphoreServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;

import java.io.IOException;

public class SemaphoreServer {

    public static void main(String[] args) {
        startServerAtPort(9000).run();
    }

    public static Runnable startServerAtPort(int port) {
        return () -> {
            Server server = ServerBuilder.forPort(port)
                    .addService(new SemaphoreServiceImpl())
                    .addService(ProtoReflectionService.newInstance())
                    .build();

            System.out.println("Semaphore server started at port: " + port);

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
